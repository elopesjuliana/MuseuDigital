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

public class ObraDAOImpl implements ObraDAO {
	
	private List<Obra> lista = new ArrayList<Obra>();

	@Override
	public void adicionar(Obra o) {
		Connection con = JDBCUtil.getInstancia().openConnection();
		System.out.println("vamos adicionar a obra");
		String sql = "INSERT INTO Obra (nome, autor, disponivel, tipo) " +
					 " VALUES (?, ?, ?, ?) ";
		
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, o.getNome());
			st.setString(2, o.getAutor());
			st.setString(3, o.getDisponivel());
			st.setString(4, o.getTipo());
			
			st.executeUpdate();
			
		} catch (SQLException e ){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Obra> pesquisar(String nome) {
	
		List <Obra> lista = new ArrayList<Obra>();
		Connection con = JDBCUtil.getInstancia().openConnection();
		String sql = "SELECT nome, autor, disponivel, tipo FROM Obra WHERE nome LIKE ?";
		try {
			System.out.println("Pesquisando...");
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			
			ResultSet rs = st.executeQuery();
			System.out.println("pesquisando a obra");
			
			while (rs.next()){
				Obra o = new Obra();
				//o.setIdObra(rs.getInt("idObra"));
				o.setNome(rs.getString("nome"));
				o.setAutor(rs.getString("autor"));
				o.setDisponivel(rs.getString("disponivel"));
				o.setTipo(rs.getString("tipo"));
				System.out.println(o.getNome());
				lista.add(o);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}

}
