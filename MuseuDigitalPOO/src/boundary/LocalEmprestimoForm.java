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
import javax.swing.JTextField;

import controller.LocalEmprestimoControl;
import entity.LocalEmprestimo;


public class LocalEmprestimoForm implements ActionListener {
	
	private JFrame janela = new JFrame("Gestão de Locais de Empréstimo");
	private JTextField txtNomeLocal = new JTextField();
	private JTextField txtNomeResponsavel = new JTextField();
	private JTextField txtTel = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtLograd = new JTextField();
	private JTextField txtNum = new JTextField();
	private JTextField txtCompl = new JTextField();
	private JTextField txtBairro = new JTextField();
	private JTextField txtCidade = new JTextField();
	private JTextField txtUf = new JTextField();
	private JTextField txtCep = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private LocalEmprestimoControl controle = new LocalEmprestimoControl();
	
	public LocalEmprestimoForm() { 
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(6, 2) );
		JScrollPane panTabela = new JScrollPane( );
		
		janela.setContentPane( panPrincipal );
		panPrincipal.add( panForm, BorderLayout.NORTH );
		panPrincipal.add( panTabela, BorderLayout.CENTER );
		
		panForm.add( new JLabel("Nome do Local: ") );
		panForm.add( txtNomeLocal );
		panForm.add( new JLabel("Nome do Responsável: ") );
		panForm.add( txtNomeResponsavel );
		panForm.add( new JLabel("Telefone: ") );
		panForm.add( txtTel );
		panForm.add( new JLabel("E-mail: ") );
		panForm.add( txtEmail );
		panForm.add( new JLabel("Logradouro: ") );
		panForm.add( txtLograd );
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
		panForm.add( btnAdicionar );
		panForm.add( btnPesquisar );
		
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
		janela.setSize(650, 200);
		janela.setVisible( true );
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void localEmpToForm(LocalEmprestimo l) {
		txtNomeLocal.setText(l.getNome());
		txtNomeResponsavel.setText(l.getNomeResponsavel());
		txtTel.setText(l.getTel()); 
		txtEmail.setText(l.getEmail()); 
		txtLograd.setText(l.getLograd());
		txtNum.setText(l.getNum()); 
		txtCompl.setText(l.getCompl()); 
		txtBairro.setText(l.getBairro()); 
		txtCidade.setText(l.getCidade()); 
		txtUf.setText(l.getUf()); 
		txtCep.setText(l.getCep());
	}
	
	public LocalEmprestimo formToLocalEmp() { 
		LocalEmprestimo l = new LocalEmprestimo();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		l.setNome(txtNomeLocal.getText());
		l.setNomeResponsavel(txtNomeResponsavel.getText());
		l.setTel(txtTel.getText());
		l.setEmail(txtEmail.getText());
		l.setLograd(txtLograd.getText());
		l.setNum(txtNum.getText());
		l.setCompl(txtCompl.getText());
		l.setBairro(txtBairro.getText());
		l.setCidade(txtCidade.getText());
		l.setUf(txtUf.getText());
		l.setCep(txtCep.getText());
		
		return l;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals( cmd ) ) { 
			controle.adicionar( formToLocalEmp() );
		} else if ("Pesquisar".equals( cmd ) ) {
			List<LocalEmprestimo> lista = controle.pesquisar( txtNomeLocal.getText());
			if (lista.size() > 0) { 
				localEmpToForm( lista.get(0) );
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new LocalEmprestimoForm();
	}

}
