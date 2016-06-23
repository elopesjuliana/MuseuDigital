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

import controller.EmprestimoControl;
import entity.Emprestimo;

public class EmprestimoForm implements ActionListener{
	
	private JFrame janela = new JFrame("Gestão de Emprestimo");
	private JTextField txtLocalEmprestimo = new JTextField();
	private JTextField txtObra = new JTextField();
	private JTextField txtDataEmprestimo = new JTextField();
	private JTextField txtDataDevolucao = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private EmprestimoControl controle = new EmprestimoControl();
	
	public EmprestimoForm() { 
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(6, 2) );
		JScrollPane panTabela = new JScrollPane( );
		
		janela.setContentPane( panPrincipal );
		panPrincipal.add( panForm, BorderLayout.NORTH );
		panPrincipal.add( panTabela, BorderLayout.CENTER );
		
		panForm.add( new JLabel("Local de Emprestimo") );
		panForm.add( txtLocalEmprestimo );
		panForm.add( new JLabel("Nome da Obra") );
		panForm.add( txtObra );
		panForm.add( new JLabel("Data de Empréstimo") );
		panForm.add( txtDataEmprestimo );
		panForm.add( new JLabel("Data de Devolução") );
		panForm.add( txtDataDevolucao );
		panForm.add( btnAdicionar );
		panForm.add( btnPesquisar );
		
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
		janela.setSize(400, 200);
		janela.setVisible( true );
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void emprestimoToForm(Emprestimo e) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		txtLocalEmprestimo.setText(e.getLocalObraEmprestimo());
		txtObra.setText(e.getObraEmprestimo());
		txtDataEmprestimo.setText(sdf.format(e.getDataEmprestimo()));
		txtDataDevolucao.setText(sdf.format(e.getDataEmprestimo()));
	}
	
	public Emprestimo formToEmprestimo() { 
		Emprestimo emp = new Emprestimo();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		emp.setLocalObraEmprestimo(txtLocalEmprestimo.getText());
		emp.setObraEmprestimo(txtObra.getText());
		try {
			emp.setDataEmprestimo(sdf.parse(txtDataEmprestimo.getText()));
			emp.setDataDevolucao(sdf.parse(txtDataDevolucao.getText()));
		} catch (ParseException e ){
			e.printStackTrace();
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		return emp;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals( cmd ) ) { 
			controle.adicionar( formToEmprestimo() );
		} else if ("Pesquisar".equals( cmd ) ) {
			List<Emprestimo> lista = controle.pesquisar( txtObra.getText() );
			if (lista.size() > 0) { 
				emprestimoToForm( lista.get(0) );
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new EmprestimoForm();
	}

}
