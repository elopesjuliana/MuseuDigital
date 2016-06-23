package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.LocalEmprestimo;

public class LocalEmprestimoDAOImpl implements LocalEmprestimoDAO {

	@Override
	public void adicionar (LocalEmprestimo l) {
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "INSERT INTO LocalEmprestimo (nome, nomeResponsavel, tel, email, lograd, num, compl, bairro, cidade, uf, cep) " +
					 " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			//st.setInt(1, l.getIdObra());
			st.setString(1, l.getNome());
			st.setString(2, l.getNomeResponsavel());
			st.setString(3, l.getTel());
			st.setString(4, l.getEmail());
			st.setString(5, l.getLograd());
			st.setString(6, l.getNum());
			st.setString(7, l.getCompl());
			st.setString(8, l.getBairro());
			st.setString(9, l.getCidade());
			st.setString(10, l.getUf());
			st.setString(11, l.getCep());
			
			st.executeUpdate();
			
		} catch (SQLException e ){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		
	}
	

}
