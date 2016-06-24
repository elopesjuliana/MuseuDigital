package boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.VendaIngressoControl;
import entity.Ingresso;
import entity.VendaIngresso;


public class VendaIngressoForm implements ActionListener {
	
	private JFrame janela = new JFrame("Venda de Ingressos");
	private JTextField txtIdVisitante = new JTextField();
	private JTextField txtDataVenda = new JTextField();
	private JTextField txtValorIngresso = new JTextField();
	private JTextField txtformaDePgto = new JTextField();
	private JTextField txtValorRecebido = new JTextField();
	
	private JButton btnAdicionar = new JButton("Adicionar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private VendaIngressoControl controle = new VendaIngressoControl();
	Ingresso i = new Ingresso();
	
	public VendaIngressoForm() { 
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(7, 1) );
		JScrollPane panTabela = new JScrollPane( );
		
		janela.setContentPane( panPrincipal );
		panPrincipal.add( panForm, BorderLayout.NORTH );
		panPrincipal.add( panTabela, BorderLayout.CENTER );
		
		panForm.add( new JLabel("Código do Visitante") );
		panForm.add( txtIdVisitante );
		panForm.add( new JLabel("Data de Venda") );
		panForm.add( txtDataVenda );
		panForm.add( new JLabel("Valor do Ingresso") );
		panForm.add( txtValorIngresso );
		panForm.add( new JLabel("Meio de Pagamento"));
		panForm.add( txtformaDePgto );
		panForm.add( new JLabel("Valor Recebido") );
		panForm.add( txtValorRecebido );
//		panForm.add( new JLabel("Troco") );
//		panForm.add(txtTroco);
		panForm.add( btnAdicionar );
		
		btnAdicionar.addActionListener( this );
		
		janela.setSize(500, 225);
		janela.setVisible( true );
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	public VendaIngresso formToVendaIngresso() { 
		VendaIngresso vIngresso = new VendaIngresso();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		vIngresso.setIdVisitante(Integer.valueOf(txtIdVisitante.getText()));
		try {
			vIngresso.setDataVenda(sdf.parse(txtDataVenda.getText()));
		} catch (ParseException e ){
			e.printStackTrace();
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		vIngresso.setValorIngresso(Double.valueOf(txtValorIngresso.getText()));
		vIngresso.setFormaDePgto(txtformaDePgto.getText());
		vIngresso.setValorRecebido(Double.valueOf(txtValorRecebido.getText()));	
		//vIngresso.setValorTroco(Double.valueOf(jTroco.getText()));
		return vIngresso;
	}
	
	public double calculaTroco(){
		VendaIngresso vi = new VendaIngresso();
		double troco = vi.getValorRecebido() - vi.getValorIngresso();
		return troco;
	}
	
	public void exibeTroco(){
		System.out.println("Seu troco é:" + calculaTroco());
	}
	
	public void actionPerformed(ActionEvent e) {
			controle.adicionar( formToVendaIngresso());
			exibeTroco();
			JOptionPane.showMessageDialog(null,"Venda realizada com sucesso!");
	}
	
	
	public static void main(String[] args) {
		new VendaIngressoForm();
	}

}
