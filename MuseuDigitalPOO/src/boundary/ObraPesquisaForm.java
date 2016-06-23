package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ObraControl;
import entity.Exposicao;
import entity.Obra;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class ObraPesquisaForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPesqObra;
	private JButton btnPesquisar;
	
	private ObraControl controle = new ObraControl();
	private JLabel lblAutor;
	private JLabel lblDisponvel;
	private JLabel lblTipo;
	private JTextField txtAutorPesqObra;
	private JTextField txtDisponivel;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObraPesquisaForm frame = new ObraPesquisaForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ObraPesquisaForm() {
		setTitle("Pesquisa de Obra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomePesq = new JLabel("Digite o nome da obra:");
		
		txtPesqObra = new JTextField();
		txtPesqObra.setColumns(4);
		//dtm.addRow(new Object[]{"Nome","Autor","Disponivel","Tipo"});
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				controle.pesquisar(txtPesqObra.getText());
			}
			
		});
		
		lblAutor = new JLabel("Autor:");
		
		lblDisponvel = new JLabel("Dispon\u00EDvel:");
		
		lblTipo = new JLabel("Tipo:");
		
		txtAutorPesqObra = new JTextField();
		txtAutorPesqObra.setColumns(10);
		
		txtDisponivel = new JTextField();
		txtDisponivel.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblAutor)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtAutorPesqObra, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNomePesq)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPesqObra, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(btnPesquisar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDisponvel)
								.addComponent(lblTipo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDisponivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNomePesq))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPesqObra, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(txtAutorPesqObra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDisponvel)
						.addComponent(txtDisponivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public void obraToForm (Obra o){
		txtAutorPesqObra.setText(o.getAutor());
		txtDisponivel.setText(Boolean.toString((o.isDisponivel())));
		txtTipo.setText(String.valueOf((o.getTipo())));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Obra> lista = controle.pesquisar(txtPesqObra.getText());
		if (lista.size() > 0){
			Obra o = lista.get(0);
			obraToForm(o);
		}
	}
	
}
