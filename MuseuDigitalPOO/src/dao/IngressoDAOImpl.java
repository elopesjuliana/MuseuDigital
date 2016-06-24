package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Ingresso;

public class IngressoDAOImpl implements IngressoDAO {

	@Override
	public void adicionar(Ingresso i) {
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "INSERT INTO Ingresso (idExposicao, tipo, preco) " +
					 " VALUES (?, ?, ?) ";
		
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);

			
			st.setInt(1, i.getIdExposicao());
			st.setString(2, i.getTipo());
			st.setDouble(3, i.getPreco());
			
			
			st.executeUpdate();
			
		} catch (SQLException s ){
			s.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		
	}

}
