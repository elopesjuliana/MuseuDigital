package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Emprestimo;

public class EmprestimoDAOImpl implements EmprestimoDAO {

	@Override
	public void adicionar(Emprestimo emp) {
		System.out.println("vou adicionar..");
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		System.out.println("conexao aberta");
		String sql = "INSERT INTO Emprestimo (localObraEmprestimo, obraEmprestimo, dataEmprestimo, dataDevolucao) " +
					 " VALUES (?, ?, ?, ?) ";
		System.out.println(sql);
		
		try {
			System.out.println("adicionando");
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			//st.setInt(1, o.getIdObra());
			st.setString(1, emp.getLocalObraEmprestimo());
			st.setString(2, emp.getObraEmprestimo());
			java.sql.Date d = new java.sql.Date(emp.getDataEmprestimo().getTime());
			st.setDate(3, d);
			java.sql.Date d2 = new java.sql.Date(emp.getDataDevolucao().getTime());
			st.setDate(4, d2);
			
			st.executeUpdate();
			
		} catch (SQLException e ){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();

		
	}

}
