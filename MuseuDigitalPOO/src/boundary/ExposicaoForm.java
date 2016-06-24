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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ExposicaoControl;
import entity.Exposicao;

public class ExposicaoForm implements ActionListener {
	
	private JFrame janela = new JFrame("Gestão de Exposições");
	private JTextField txtNomeExposicao = new JTextField();
	private JTextField txtDataInicio = new JTextField();
	private JTextField txtDataFim = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private ExposicaoControl controle = new ExposicaoControl();
	
	public ExposicaoForm() { 
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(6, 2) );
		JScrollPane panTabela = new JScrollPane( );
		
		janela.setContentPane( panPrincipal );
		panPrincipal.add( panForm, BorderLayout.NORTH );
		panPrincipal.add( panTabela, BorderLayout.CENTER );
		
		panForm.add( new JLabel("Nome da Exposição") );
		panForm.add( txtNomeExposicao );
		panForm.add( new JLabel("Data de Inicio") );
		panForm.add( txtDataInicio );
		panForm.add( new JLabel("Data de Fim") );
		panForm.add( txtDataFim );
		panForm.add( btnAdicionar );
		panForm.add( btnPesquisar );
		
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
		janela.setSize(400, 200);
		janela.setVisible( true );
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void exposicaoToForm(Exposicao exp) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		txtNomeExposicao.setText(exp.getNomeExposicao());
		txtDataInicio.setText(sdf.format(exp.getDataInicio()));
		txtDataFim.setText(sdf.format(exp.getDataFim()));
	}
	
	public Exposicao formToExposicao() { 
		Exposicao exp = new Exposicao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		exp.setNomeExposicao(txtNomeExposicao.getText());
		try {
			exp.setDataInicio(sdf.parse(txtDataInicio.getText()));
			exp.setDataFim(sdf.parse(txtDataFim.getText()));
		} catch (ParseException e ){
			e.printStackTrace();
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		return exp;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals( cmd ) ) { 
			controle.adicionar( formToExposicao() );
			JOptionPane.showMessageDialog(null,"Exposição adicionada com sucesso!");
		} else if ("Pesquisar".equals( cmd ) ) {
			List<Exposicao> lista = controle.pesquisar( txtNomeExposicao.getText());
			if (lista.size() > 0) { 
				exposicaoToForm( lista.get(0) );
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new ExposicaoForm();
	}


}
