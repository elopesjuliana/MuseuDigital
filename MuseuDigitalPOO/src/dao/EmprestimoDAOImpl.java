package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Emprestimo;
import entity.Exposicao;

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
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
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

	@Override
	public List<Emprestimo> pesquisar(String nome) {
		List <Emprestimo> lista = new ArrayList<Emprestimo>();
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "SELECT localObraEmprestimo, obraEmprestimo, dataEmprestimo, dataDevolucao FROM Emprestimo WHERE obraEmprestimo LIKE ?";
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				Emprestimo emp = new Emprestimo ();
				
				emp.setLocalObraEmprestimo(rs.getString("localObraEmprestimo"));
				emp.setObraEmprestimo(rs.getString("obraEmprestimo"));
				emp.setDataEmprestimo(rs.getDate("dataEmprestimo"));
				emp.setDataEmprestimo(rs.getDate("dataDevolucao"));
			
				lista.add(emp);

			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}


}
