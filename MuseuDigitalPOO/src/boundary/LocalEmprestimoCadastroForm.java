package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.INITIALIZE;

import controller.LocalEmprestimoControl;
import dao.JDBCUtil;
import entity.LocalEmprestimo;

import java.awt.CardLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LocalEmprestimoCadastroForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeLocal;
	private JTextField txtNomeResponsavel;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtLograd;
	private JTextField txtNum;
	private JTextField txtCompl;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtCep;
	JButton btnSalvar = new JButton("Salvar");
	
	private LocalEmprestimoControl controle = new LocalEmprestimoControl();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalEmprestimoCadastroForm frame = new LocalEmprestimoCadastroForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public LocalEmprestimoCadastroForm(){
		initialize();
	}

	/**
	 * Create the frame.
	 */
	//public LocalEmprestimoCadastroBoundary() {
	public void initialize(){
		setTitle("Cadastro de Local de Emprestimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		JLabel lblNomeDoLocal = new JLabel("Nome do Local:");
		JLabel lblNomeDoResponsvel = new JLabel("Nome do Respons\u00E1vel:");
		JLabel lblTelefone = new JLabel("Telefone:");
		JLabel lblEmail = new JLabel("E-mail:");
		JLabel lblLogradouro = new JLabel("Logradouro:");
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		JLabel label_1 = new JLabel("");
		JLabel lblComplemento = new JLabel("Complemento:");
		JLabel lblBairro = new JLabel("Bairro:");
		JLabel lblCidade = new JLabel("Cidade:");
		JLabel lblUf = new JLabel("UF:");
		JLabel lblCep = new JLabel("CEP:");
		
		txtNomeLocal = new JTextField();
		txtNomeLocal.setColumns(10);
		txtNomeResponsavel = new JTextField();
		txtNomeResponsavel.setColumns(10);
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtLograd = new JTextField();
		txtLograd.setColumns(10);
		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtCompl = new JTextField();
		txtCompl.setColumns(10);
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtUf = new JTextField();
		txtUf.setColumns(10);
		txtCep = new JTextField();
		txtCep.setColumns(10);
		btnSalvar.addActionListener(this);

		
//		JButton btnSalvar = new JButton("Salvar");
//		btnSalvar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCidade)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTelefone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEmail))
						.addComponent(label_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogradouro)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLograd))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNmero)
								.addComponent(lblBairro)
								.addComponent(lblUf))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblComplemento)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtCompl, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
									.addComponent(txtCidade))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtUf, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblCep)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSalvar)
										.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNomeDoResponsvel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtNomeResponsavel))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(lblNomeDoLocal)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtNomeLocal, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
					.addGap(271)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNomeDoLocal)
								.addComponent(txtNomeLocal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNomeDoResponsvel)
								.addComponent(txtNomeResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLogradouro)
								.addComponent(txtLograd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNmero)
								.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblComplemento)
								.addComponent(txtCompl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblBairro)
									.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCidade)
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUf)
								.addComponent(txtUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCep)
								.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSalvar)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public LocalEmprestimo formToLocalEmprestimo(){
		LocalEmprestimo l = new LocalEmprestimo();
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controle.adicionar(formToLocalEmprestimo());
		
	}
	


}
