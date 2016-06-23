package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;

public class Principal extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Museu Digital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestaoObras = new JButton("Gestão de Obras");
		btnGestaoObras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ObraForm form1 = new ObraForm();
			}
		});
		btnGestaoObras.setBounds(10, 99, 177, 23);
		contentPane.add(btnGestaoObras);
		
		
		JButton btnGestaoEmprestimo = new JButton("Gestão de Empréstimos");
		btnGestaoEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoForm form3 = new EmprestimoForm();
			}
		});
		btnGestaoEmprestimo.setBounds(10, 133, 177, 23);
		contentPane.add(btnGestaoEmprestimo);
		
		
		JButton btnGestaoExposicao = new JButton("Gestão de Exposições");
		btnGestaoExposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExposicaoForm form5 = new ExposicaoForm();
			}
		});
		btnGestaoExposicao.setBounds(197, 133, 191, 23);
		contentPane.add(btnGestaoExposicao);
		
		JButton btnGestaoLocaisEmp = new JButton("Gestão de Locais de Empréstimos");
		btnGestaoLocaisEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalEmprestimoForm form6 = new LocalEmprestimoForm();
			}
		});
		btnGestaoLocaisEmp.setBounds(197, 99, 191, 23);
		contentPane.add(btnGestaoLocaisEmp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
