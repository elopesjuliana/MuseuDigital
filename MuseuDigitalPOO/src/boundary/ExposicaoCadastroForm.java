package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ExposicaoControl;
import entity.Exposicao;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ExposicaoCadastroForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeExposicao;
	private JTextField txtDataInicio;
	private JTextField txtDataFim;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExposicaoCadastroForm frame = new ExposicaoCadastroForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ExposicaoCadastroForm() {
		setTitle("Cadastro de Exposi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomeExposicao = new JLabel("Nome da Exposi\u00E7\u00E3o: ");
		
		JLabel lblDataDeInicio = new JLabel("Data de Inicio:");
		
		JLabel lblDataDeFim = new JLabel("Data de Fim:");
		
		ExposicaoControl controle = new ExposicaoControl();
		
		txtNomeExposicao = new JTextField();
		txtNomeExposicao.setColumns(10);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		
		txtDataFim = new JTextField();
		txtDataFim.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.adicionar(formToExposicao());
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNomeExposicao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeExposicao, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDataDeInicio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDataDeFim)
							.addGap(2)
							.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(168)
					.addComponent(btnSalvar)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeExposicao)
						.addComponent(txtNomeExposicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeInicio)
						.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataDeFim))
					.addGap(18)
					.addComponent(btnSalvar)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public Exposicao formToExposicao(){
		Exposicao e = new Exposicao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		e.setNomeExposicao(txtNomeExposicao.getText());
		try {
			e.setDataInicio(sdf.parse(txtDataInicio.getText()));
			e.setDataFim(sdf.parse(txtDataFim.getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return e;
	}


}
