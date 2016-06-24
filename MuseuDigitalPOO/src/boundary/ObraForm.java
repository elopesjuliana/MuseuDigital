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

import controller.ObraControl;
import entity.Obra;


public class ObraForm implements ActionListener {

	private JFrame janela = new JFrame("Gestão de Obras de Arte");
	private JTextField txtNome = new JTextField();
	private JTextField txtAutor = new JTextField();
	private JTextField txtDisponivel = new JTextField();
	private JTextField txtTipo = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private ObraControl controle = new ObraControl();
	
	public ObraForm() { 
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(6, 2) );
		JScrollPane panTabela = new JScrollPane( );
		
		janela.setContentPane( panPrincipal );
		panPrincipal.add( panForm, BorderLayout.NORTH );
		panPrincipal.add( panTabela, BorderLayout.CENTER );
		
		panForm.add( new JLabel("Nome da Obra: ") );
		panForm.add( txtNome );
		panForm.add( new JLabel("Nome do Autor: ") );
		panForm.add( txtAutor );
		panForm.add( new JLabel("Disponível: ") );
		panForm.add( txtDisponivel );
		panForm.add( new JLabel("Tipo: ") );
		panForm.add( txtTipo );
		panForm.add( btnAdicionar );
		panForm.add( btnPesquisar );
		
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
		janela.setSize(400, 200);
		janela.setVisible( true );
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void obraToForm(Obra o) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		txtNome.setText(o.getNome());
		txtAutor.setText(o.getAutor());
		txtDisponivel.setText(o.getDisponivel());
		txtTipo.setText(o.getTipo());
	}
	
	public Obra formToObra() { 
		Obra o = new Obra();
		o.setNome(txtNome.getText());
		o.setAutor(txtAutor.getText());
		o.setDisponivel(txtDisponivel.getText());
		o.setTipo(txtTipo.getText());
		return o;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals( cmd ) ) { 
			controle.adicionar( formToObra() );
			 JOptionPane.showMessageDialog(null,"Obra adicionada com sucesso!");
		} else if ("Pesquisar".equals( cmd ) ) {
			List<Obra> lista = controle.pesquisar( txtNome.getText());
			if (lista.size() > 0) { 
				obraToForm( lista.get(0) );
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new ObraForm();
	}

}
