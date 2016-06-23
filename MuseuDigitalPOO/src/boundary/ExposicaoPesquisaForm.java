package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import controller.ExposicaoControl;
import entity.Exposicao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JEditorPane;

public class ExposicaoPesquisaForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeExposicao;
	ExposicaoControl controle = new ExposicaoControl();
	private JTextField txtDataInicio;
	private JTextField txtDataFim;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExposicaoPesquisaForm frame = new ExposicaoPesquisaForm();
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
	public ExposicaoPesquisaForm() {
		setTitle("Pesquisar Exposi\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome da exposi\u00E7\u00E3o:");
		lblDigiteONome.setBounds(10, 11, 186, 14);
		contentPane.add(lblDigiteONome);
		
		txtNomeExposicao = new JTextField();
		txtNomeExposicao.setBounds(194, 8, 272, 20);
		contentPane.add(txtNomeExposicao);
		txtNomeExposicao.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(356, 39, 113, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblDataInicio = new JLabel("Data de Inicio:");
		lblDataInicio.setBounds(10, 64, 99, 14);
		contentPane.add(lblDataInicio);
		
		JLabel lblDataFim = new JLabel("Data de Fim:");
		lblDataFim.setBounds(10, 89, 99, 14);
		contentPane.add(lblDataFim);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setBounds(119, 61, 113, 20);
		contentPane.add(txtDataInicio);
		txtDataInicio.setColumns(10);
		
		txtDataFim = new JTextField();
		txtDataFim.setBounds(119, 86, 113, 20);
		contentPane.add(txtDataFim);
		txtDataFim.setColumns(10);
		
	}

	public void exposicaoToForm (Exposicao e){
		SimpleDateFormat sdf = new SimpleDateFormat();
		txtDataInicio.setText(sdf.format(e.getDataInicio()));
		txtDataFim.setText(sdf.format(e.getDataFim()));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Exposicao> lista = controle.pesquisar(txtNomeExposicao.getText());
		if (lista.size() > 0){
			exposicaoToForm(lista.get(0));
		}
	}
}
