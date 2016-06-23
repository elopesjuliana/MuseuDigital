package boundary;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ObraControl;
import entity.Obra;

public class ObraForm implements ActionListener {

	private JFrame frame;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
    private JRadioButton rdbtnSim;
    private JRadioButton rdbtnNo;
    private JRadioButton rdbtnPintura;
    private JRadioButton rdbtnEscultura;
    private JButton btnSalvar = new JButton("Salvar");
    
	private ObraControl controle = new ObraControl();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		ObraForm form = new ObraForm();
	
	}*/

	/**
	 * Create the application.
	 */
	public ObraForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cadastro de Obra");
		frame.setBounds(100, 100, 500, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel lblNomeDaObra = new JLabel("Nome da Obra:");
		txtNomeObra = new JTextField();
		txtNomeObra.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		txtNomeAutor = new JTextField();
		txtNomeAutor.setColumns(10);
		
		JLabel lblDispinvel = new JLabel("Dispin\u00EDvel:");
		rdbtnSim = new JRadioButton("Sim");
		rdbtnNo = new JRadioButton("N\u00E3o");
		
		JLabel lblTipo = new JLabel("Tipo:");
		rdbtnPintura = new JRadioButton("Pintura");
		rdbtnEscultura = new JRadioButton("Escultura");

		btnSalvar.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNomeDaObra, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblAutor)
											.addGap(56)))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblDispinvel)
										.addGap(39)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTipo)
									.addGap(63)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnSim)
									.addGap(18)
									.addComponent(rdbtnNo))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnPintura)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnEscultura))
								.addComponent(txtNomeObra, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
								.addComponent(txtNomeAutor)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(195)
							.addComponent(btnSalvar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDaObra, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomeObra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(txtNomeAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDispinvel)
						.addComponent(rdbtnSim)
						.addComponent(rdbtnNo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(rdbtnPintura)
						.addComponent(rdbtnEscultura))
					.addGap(18)
					.addComponent(btnSalvar)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	
	boolean escolheDisponivel(){
		if (rdbtnSim.isSelected()){
			return true;
		} else {
			return false;
		}
	}
	
	public int escolheTipoObra(){
		if (rdbtnPintura.isSelected()){
			return 1;
		} else {
			return 2;
		}
	}
		
	
	public Obra formToObra(){
		Obra o = new Obra();
			o.setNome(txtNomeObra.getText());
			o.setAutor(txtNomeAutor.getText());
			o.setDisponivel(escolheDisponivel());
			o.setTipo(escolheTipoObra());
			return o;
    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controle.adicionar(formToObra());
		
	}
	
	


		
	

}
