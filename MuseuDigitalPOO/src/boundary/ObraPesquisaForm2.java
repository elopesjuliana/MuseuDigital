package boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ObraControl;
import entity.Obra;


public class ObraPesquisaForm2 implements ActionListener{
	
	private JFrame janela = new JFrame("Pesquisa de Obras");
	private JLabel lblNomePesquisa = new JLabel("Digite o nome da obra: ");
	private JTextField txNomePesquisa = new JTextField();
	private JButton btnPesquisar = new JButton("Pesquisar");
	private ObraControl control = new ObraControl();
	private JTable tabela;
	
	public ObraPesquisaForm2() {
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JScrollPane panTable = new JScrollPane();
		//JPanel panFormulario = new JPanel( new GridLayout(5, 2) );
//		panFormulario.add( new JLabel("Nome") );
//		panFormulario.add( txtId );
//		panFormulario.add( new JLabel("Numero") );
//		panFormulario.add( txtNumero );
//		panFormulario.add( new JLabel("Desricao") );
//		panFormulario.add( txtDescricao );
//		panFormulario.add( new JLabel("Entrega") );
//		panFormulario.add( txtEntrega );
//		panFormulario.add( btnAdicionar );
//		panFormulario.add( btnPesquisar );
//		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
//		panPrincipal.add(panFormulario, BorderLayout.NORTH);
		panPrincipal.add(lblNomePesquisa, BorderLayout.NORTH);
		panPrincipal.add(txNomePesquisa), BorderLayout.WEST);
		panPrincipal.add(panTable, BorderLayout.CENTER);
		
		
		Object []  vetor = {1, 2, 3, 4};
		
//		JTable tabela = new JTable( new Object[][] {
//				{1, 2, 3, 4},
//				{5, 6, 7, 8},
//				{9, 10, 11, 12} }, 
//				
//				new Object[] { "Coluna1", "Coluna2", 
//				"Coluna3", "Coluna4" });
		
		tabela = new JTable( control );
		
		panTable.getViewport().add( tabela );
		
		janela.setContentPane( panPrincipal );
		
		janela.setSize(400, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ObraPesquisaForm();
	}
	
	public  Obra formToObra() { 
		Obra o = new Obra();
		o.setNome(nome);
		o.setId( Long.parseLong( txtId.getText() ) );
		o.setNumero( Long.parseLong( txtNumero.getText() ) );
		try {
			o.setEntrega( sdf.parse(txtEntrega.getText() ) );
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		o.setDescricao( txtDescricao.getText() );
		return o;
	}
	
	private void osToForm(OS o) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtId.setText( String.valueOf( o.getId() ) );
		txtNumero.setText( String.valueOf( o.getNumero() ) );
		txtDescricao.setText( o.getDescricao() );
		txtEntrega.setText( sdf.format( o.getEntrega() ) );
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			control.adicionar( formToOS() );
			tabela.invalidate();
			tabela.revalidate();
		} else if (e.getSource() == btnPesquisar) { 
			List<OS> lista = control.pesquisar( txtDescricao.getText() );
			if ( lista.size() > 0) { 
				OS o = lista.get( 0 );
				osToForm( o );
			}
		}
		
	}

}
