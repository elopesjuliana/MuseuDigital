package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

import com.mysql.jdbc.PreparedStatement;

import controller.EmprestimoControl;
import dao.EmprestimoDAOImpl;
import dao.JDBCUtil;
import entity.Emprestimo;
import entity.LocalEmprestimo;
import entity.Obra;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class EmprestimoCadastroForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDataEmprestimo;
	private JTextField txtDataDevolucao;
	JComboBox cmbLocalEmprestimo = new JComboBox();
	JComboBox cmbObra = new JComboBox();
	private JButton btnSalvar = new JButton("Salvar");
	EmprestimoControl controle = new EmprestimoControl();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprestimoCadastroForm frame = new EmprestimoCadastroForm();
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
	public EmprestimoCadastroForm() {
		setTitle("Empr\u00E9stimo de Obra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocalDeEmprstimo = new JLabel("Local de Empr\u00E9stimo:");
		lblLocalDeEmprstimo.setBounds(10, 11, 122, 14);
		contentPane.add(lblLocalDeEmprstimo);
		
		JLabel lblObra = new JLabel("Obra:");
		lblObra.setBounds(10, 36, 46, 14);
		contentPane.add(lblObra);
		
		JLabel lblDataEmprstimo = new JLabel("Data Empr\u00E9stimo:");
		lblDataEmprstimo.setBounds(10, 72, 85, 14);
		contentPane.add(lblDataEmprstimo);
		
		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o:");
		lblDataDevoluo.setBounds(10, 97, 85, 14);
		contentPane.add(lblDataDevoluo);
		
		JComboBox cmbLocalEmprestimo = new JComboBox();
		cmbLocalEmprestimo.setModel(new DefaultComboBoxModel(new String[] {"Masp", "Memorial da America Latina", "Museu do Ipiranga", "Itau Cultural", "Museu do Futebol", "Museu do Amanha"}));
		cmbLocalEmprestimo.setBounds(142, 8, 122, 20);
		contentPane.add(cmbLocalEmprestimo);
		
		JComboBox cmbObra = new JComboBox();
		cmbObra.setModel(new DefaultComboBoxModel(new String[] {"Abapuru", "Monalisa", "Os Tres Girassois", "O Grito", "Venus de Milo", "A Noite Estrelada"}));
		cmbObra.setBounds(97, 33, 127, 20);
		contentPane.add(cmbObra);
		
		txtDataEmprestimo = new JTextField();
		txtDataEmprestimo.setBounds(102, 68, 101, 20);
		contentPane.add(txtDataEmprestimo);
		txtDataEmprestimo.setColumns(10);
		
		txtDataDevolucao = new JTextField();
		txtDataDevolucao.setBounds(102, 94, 101, 20);
		contentPane.add(txtDataDevolucao);
		txtDataDevolucao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(135, 138, 89, 23);
		contentPane.add(btnSalvar);
	}
	
		
	public Emprestimo formToEmprestimo(){
		Emprestimo emp = new Emprestimo();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		   emp.setLocalObraEmprestimo (cmbLocalEmprestimo.getSelectedItem().toString());
		   emp.setObraEmprestimo (cmbObra.getSelectedItem().toString());
		   try {
			   emp.setDataEmprestimo(sdf.parse(txtDataEmprestimo.getText()));
			   emp.setDataDevolucao(sdf.parse(txtDataDevolucao.getText()));
		   } catch (ParseException e){
			   e.printStackTrace();
		   }
		   return emp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controle.adicionar(formToEmprestimo());
	}

	
		   	
	
}
