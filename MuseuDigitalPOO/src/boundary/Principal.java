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
		setBounds(100, 100, 656, 422);
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
		btnGestaoObras.setBounds(337, 192, 183, 23);
		contentPane.add(btnGestaoObras);
		
		
		JButton btnGestaoEmprestimo = new JButton("Gestão de Empréstimos");
		btnGestaoEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoForm form3 = new EmprestimoForm();
			}
		});
		btnGestaoEmprestimo.setBounds(136, 192, 191, 23);
		contentPane.add(btnGestaoEmprestimo);
		
		
		JButton btnGestaoExposicao = new JButton("Gestão de Exposições");
		btnGestaoExposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExposicaoForm form5 = new ExposicaoForm();
			}
		});
		btnGestaoExposicao.setBounds(337, 157, 183, 23);
		contentPane.add(btnGestaoExposicao);
		
		JButton btnGestaoLocaisEmp = new JButton("Gestão de Locais de Empréstimos");
		btnGestaoLocaisEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalEmprestimoForm form6 = new LocalEmprestimoForm();
			}
		});
		btnGestaoLocaisEmp.setBounds(136, 157, 191, 24);
		contentPane.add(btnGestaoLocaisEmp);
		
		JButton btnCadastroDeVisitantes = new JButton("Cadastro de Visitantes");
		btnCadastroDeVisitantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisitanteForm form8 = new VisitanteForm();
			}
		});
		btnCadastroDeVisitantes.setBounds(136, 123, 191, 23);
		contentPane.add(btnCadastroDeVisitantes);
		
		JButton btnCadastroDeIngressos = new JButton("Cadastro de Ingressos");
		btnCadastroDeIngressos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngressoForm form7 = new IngressoForm();
			}
		});
		btnCadastroDeIngressos.setBounds(337, 123, 183, 23);
		contentPane.add(btnCadastroDeIngressos);
		
		JButton btnVendaDeIngressos = new JButton("Venda de Ingressos");
		btnVendaDeIngressos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaIngressoForm form9 = new VendaIngressoForm();
			}
		});
		btnVendaDeIngressos.setBounds(136, 226, 384, 23);
		contentPane.add(btnVendaDeIngressos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
