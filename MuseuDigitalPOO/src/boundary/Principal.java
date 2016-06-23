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
		setBounds(100, 100, 431, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarObra = new JButton("Cadastrar Obra");
		btnCadastrarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ObraForm form1 = new ObraForm();
			}
		});
		btnCadastrarObra.setBounds(23, 65, 164, 23);
		contentPane.add(btnCadastrarObra);
		
		JButton btnPesquisarObra = new JButton("Pesquisar Obra");
		btnPesquisarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObraPesquisaForm form2 = new ObraPesquisaForm();
			}
		});
		btnPesquisarObra.setBounds(23, 99, 164, 23);
		contentPane.add(btnPesquisarObra);
		
		JButton btnEmprstimo = new JButton("Empr\u00E9stimo");
		btnEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoCadastroForm form2 = new EmprestimoCadastroForm();
			}
		});
		btnEmprstimo.setBounds(23, 133, 164, 23);
		contentPane.add(btnEmprstimo);
		
		JButton btnCadastroLocal = new JButton("Cadastrar Local de Empr\u00E9stimo");
		btnCadastroLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalEmprestimoCadastroForm form4 = new LocalEmprestimoCadastroForm();
			}
		});
		btnCadastroLocal.setBounds(197, 65, 181, 23);
		contentPane.add(btnCadastroLocal);
		
		JButton btnPesquisaExposicao = new JButton("Pesquisar Exposi\u00E7\u00E3o");
		btnPesquisaExposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExposicaoPesquisaForm form5 = new ExposicaoPesquisaForm();
			}
		});
		btnPesquisaExposicao.setBounds(197, 133, 181, 23);
		contentPane.add(btnPesquisaExposicao);
		
		JButton btnCadastrarExposio = new JButton("Cadastrar Exposi\u00E7\u00E3o");
		btnCadastrarExposio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExposicaoCadastroForm form6 = new ExposicaoCadastroForm();
			}
		});
		btnCadastrarExposio.setBounds(197, 99, 181, 23);
		contentPane.add(btnCadastrarExposio);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
