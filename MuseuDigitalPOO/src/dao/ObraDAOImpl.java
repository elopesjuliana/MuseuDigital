package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.mysql.jdbc.PreparedStatement;

import entity.Obra;

public class ObraDAOImpl implements ObraDAO, TableModel {
	
	private List<Obra> lista = new ArrayList<Obra>();

	@Override
	public void adicionar(Obra o) {
		System.out.println(o.toString());
		Connection con = JDBCUtil.getInstancia().openConnection();
		System.out.println("conexão: " + con);
		System.out.println("vamos adicionar a obra");
		String sql = "INSERT INTO Obra (nome, autor, disponivel, tipo) " +
					 " VALUES (?, ?, ?, ?) ";
		System.out.println(sql);
		
		try {
			//System.out.println("Adicionando obra... ");
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			//st.setInt(1, o.getIdObra());
			st.setString(1, o.getNome());
			st.setString(2, o.getAutor());
			st.setBoolean(3, o.isDisponivel());
			st.setInt(4, o.getTipo());
			
			st.executeUpdate();
			
		} catch (SQLException e ){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
	}

	/*@Override
	public List<Obra> pesquisar(String nome) {
		
		List <Obra> lista = new ArrayList<Obra>();
		Connection con = JDBCUtil.getInstancia().openConnection();
		String sql = "SELECT autor, disponivel, tipo FROM Obra WHERE nome LIKE ?";
		try {
			System.out.println("Pesquisando...");
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			
			ResultSet rs = st.executeQuery();
			System.out.println("inserindo a obra");
			while (rs.next()){
				Obra o = new Obra ();
				//o.setIdObra(rs.getInt("idObra"));
				//o.setNome(rs.getString("nome"));
				o.setAutor(rs.getString("autor"));
				o.setDisponivel(rs.getBoolean("disponivel"));
				o.setTipo(rs.getInt("tipo"));
				
				lista.add(o);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}*/
	@Override
	public List<Obra> pesquisar (String descricao){
		List<Obra> resultados = new ArrayList<Obra>();
		for (Obra o : lista){
			if (o.getNome().contains(descricao)){
				resultados.add(o);
			}
		}
		return lista;
	}
	
	public List<Obra> getLista(){
		return lista;
	}
	
	public void setLista(List<Obra> lista){
		this.lista = lista;
	}
	
	

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0: return String.class;
		case 1: return String.class;
		case 2: return Boolean.class;
		case 3: return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String [] nomes = {"Nome da Obra", "Autor", "Disponivel", "Tipo"};
		return nomes [columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch (columnIndex){
		case 0: return o.getNome();
		case 1: return o.getAutor();
		case 3: return o.isDisponivel();
		case 4: return o.getTipo();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
			switch (columnIndex){
			case 0: o.setNome((String)aValue);
			case 1: o.setAutor((String) aValue);
			case 2: o.setDisponivel((Boolean) aValue);
			case 3: o.setTipo((Integer) aValue);
		}
		
	}

}
