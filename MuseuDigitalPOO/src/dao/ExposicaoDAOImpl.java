package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Exposicao;

public class ExposicaoDAOImpl implements ExposicaoDAO {

	@Override
	public void adicionar(Exposicao e) {
		// TODO Auto-generated method stub
		
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "INSERT INTO Exposicao (nomeExposicao, dataInicio, dataFim) " +
					 " VALUES (?, ?, ?) ";
		
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);

			//st.setInt(1, e.getIdObra());
			st.setString(1, e.getNomeExposicao());
			java.sql.Date d = new java.sql.Date(e.getDataInicio().getTime());
			st.setDate(2, d);
			java.sql.Date d2 = new java.sql.Date(e.getDataFim().getTime());
			st.setDate(3, d2);
			
			st.executeUpdate();
			
		} catch (SQLException s ){
			s.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		
	}

	@Override
	public List<Exposicao> pesquisar(String nome) {

		List <Exposicao> lista = new ArrayList<Exposicao>();
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "SELECT nomeExposicao, dataInicio, dataFim FROM Exposicao WHERE nomeExposicao LIKE ?";
		try {
			System.out.println("Pesquisando...");
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				Exposicao e = new Exposicao ();
				
				//e.setIdObra(rs.getInt("idObra"));
				e.setNomeExposicao(rs.getString("nomeExposicao"));
				e.setDataInicio(rs.getDate("dataInicio"));
				e.setDataFim(rs.getDate("dataFim"));
				
				lista.add(e);

			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}
	

}
