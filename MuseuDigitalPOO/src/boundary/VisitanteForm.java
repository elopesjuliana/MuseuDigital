package boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

import controller.VisitanteControl;
import entity.Visitante;

public class VisitanteForm implements ActionListener {
	
	private JFrame janela = new JFrame("Gestão de Visitantes");
	private JTextField txtNome = new JTextField();
	private JTextField txtNascimento = new JTextField();
	private JTextField txtTel  = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtLogradouro = new JTextField();
	private JTextField txtNum  = new JTextField();
	private JTextField txtCompl = new JTextField();
	private JTextField txtBairro = new JTextField();
	private JTextField txtCidade = new JTextField();
	private JTextField txtUf   = new JTextField();
	private JTextField txtCep  = new JTextField();
	private JTextField txtEscolaridade = new JTextField();
	private JTextField txtNacionalidade = new JTextField();
	private JTextField txtMeioTransporte = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private VisitanteControl controle = new VisitanteControl();
	
	public VisitanteForm() { 
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(20, 2) );
		JScrollPane panTabela = new JScrollPane( );
		
		janela.setContentPane( panPrincipal );
		panPrincipal.add( panForm, BorderLayout.NORTH );
		panPrincipal.add( panTabela, BorderLayout.CENTER );
		
		panForm.add( new JLabel("Nome: ") );
		panForm.add( txtNome );
		panForm.add( new JLabel("Nascimento: ") );
		panForm.add( txtNascimento );
		panForm.add( new JLabel("Telefone: ") );
		panForm.add( txtTel );
		panForm.add( new JLabel("E-mail: ") );
		panForm.add( txtEmail );
		panForm.add( new JLabel("Logradouro: ") );
		panForm.add( txtLogradouro );
		panForm.add( new JLabel("Num.: ") );
		panForm.add( txtNum );
		panForm.add( new JLabel("Compl.:") );
		panForm.add( txtCompl );
		panForm.add( new JLabel("Bairro: ") );
		panForm.add( txtBairro );
		panForm.add( new JLabel("Cidade: ") );
		panForm.add( txtCidade );
		panForm.add( new JLabel("UF: ") );
		panForm.add( txtUf );
		panForm.add( new JLabel("CEP: ") );
		panForm.add( txtCep );
		panForm.add( new JLabel("Escolaridade: ") );
		panForm.add( txtEscolaridade );
		panForm.add( new JLabel("Nacionalidade: ") );
		panForm.add( txtNacionalidade );
		panForm.add( new JLabel("Meio de Transporte: ") );
		panForm.add( txtMeioTransporte );
		panForm.add( btnAdicionar );
		panForm.add( btnPesquisar );
		
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
		janela.setSize(500, 440);
		janela.setVisible( true );
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void visitanteToForm(Visitante v) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		 txtNome.setText(v.getNome());
		 txtNascimento.setText(sdf.format(v.getNascimento()));
		 txtTel.setText(v.getTel());
		 txtEmail.setText (v.getEmail());
		 txtLogradouro.setText(v.getLograd());
		 txtNum.setText(v.getNum());
		 txtCompl.setText (v.getCompl());
		 txtBairro.setText (v.getBairro());
		 txtCidade.setText (v.getCidade());
		 txtUf.setText (v.getUf());
		 txtCep.setText (v.getCep());
		 txtEscolaridade.setText (v.getEscolaridade()) ;
		 txtNacionalidade.setText (v.getNacionalidade());
		 txtMeioTransporte.setText (v.getMeioTransporte());
	}
	
	public Visitante formToVisitante() { 
		Visitante v = new Visitante();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		v.setNome(txtNome.getText());
		try {
			v.setNascimento( sdf.parse(txtNascimento.getText()));
		} catch (ParseException e ){
			e.printStackTrace();
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		v.setTel(txtTel.getText());
		v.setEmail(txtEmail.getText());
		v.setLograd(txtLogradouro.getText());
		v.setNum(txtNum.getText());
		v.setCompl(txtCompl.getText());
		v.setBairro(txtBairro.getText());
		v.setCidade(txtCidade.getText());
		v.setUf(txtUf.getText());
		v.setCep(txtCep.getText());
		v.setEscolaridade(txtEscolaridade.getText());
		v.setNacionalidade(txtNacionalidade.getText());
		v.setMeioTransporte(txtMeioTransporte.getText());
		
		return v;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals( cmd ) ) { 
			controle.adicionar( formToVisitante() );
			JOptionPane.showMessageDialog(null,"Visitante adicionado com sucesso!");
		} else if ("Pesquisar".equals( cmd ) ) {
			List<Visitante> lista = controle.pesquisar( txtNome.getText());
			if (lista.size() > 0) { 
				visitanteToForm( lista.get(0) );
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new VisitanteForm();
	}


}
