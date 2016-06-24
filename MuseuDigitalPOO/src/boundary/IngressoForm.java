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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ExposicaoControl;
import controller.IngressoControl;
import entity.Exposicao;
import entity.Ingresso;

public class IngressoForm implements ActionListener {
	
	private JFrame janela = new JFrame("Gestão de Ingressos");
	private JTextField txtidExposicao = new JTextField();
	private JTextField txtTipo = new JTextField();
	private JTextField txtPreco = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	
	private IngressoControl controle = new IngressoControl();
	
	public IngressoForm() { 
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(4, 1) );
		JScrollPane panTabela = new JScrollPane( );
		
		janela.setContentPane( panPrincipal );
		panPrincipal.add( panForm, BorderLayout.NORTH );
		panPrincipal.add( panTabela, BorderLayout.CENTER );
		
		panForm.add( new JLabel("Codigo da Exposição: ") );
		panForm.add( txtidExposicao );
		panForm.add( new JLabel("Tipo: ") );
		panForm.add( txtTipo );
		panForm.add( new JLabel("Preço: ") );
		panForm.add( txtPreco );
		panForm.add( btnAdicionar );
		
		btnAdicionar.addActionListener( this );
		
		janela.setSize(400, 180);
		janela.setVisible( true );
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public Ingresso formToIngresso() { 
		Ingresso i = new Ingresso();
		i.setIdExposicao(Integer.valueOf(txtidExposicao.getText()));
		i.setTipo(txtTipo.getText());
		i.setPreco(Double.valueOf(txtPreco.getText()));
		return i;
	}
	
	public void actionPerformed(ActionEvent e) {
			controle.adicionar( formToIngresso() );
			JOptionPane.showMessageDialog(null,"Ingresso adicionado com sucesso!");

	}
	
	
	public static void main(String[] args) {
		new IngressoForm();
	}

}
