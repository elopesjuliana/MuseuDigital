package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	@Override
	public List<LocalEmprestimo> pesquisar(String nome) {

		List <LocalEmprestimo> lista = new ArrayList<LocalEmprestimo>();
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "SELECT nome, nomeResponsavel, tel, email, lograd, num, compl, bairro, "
				+ "cidade, uf, cep FROM LocalEmprestimo WHERE nome LIKE ?";
		try {
			System.out.println("Pesquisando pelo nome...");
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				LocalEmprestimo l = new LocalEmprestimo ();
				
				l.setNome(rs.getString("nome"));
				l.setNome(rs.getString("nomeResponsavel"));
				l.setTel(rs.getString("tel"));
				l.setEmail(rs.getString("email"));
				l.setLograd(rs.getString("lograd"));
				l.setNum(rs.getString("num"));
				l.setCompl(rs.getString("compl"));
				l.setBairro(rs.getString("bairro"));
				l.setCidade(rs.getString("cidade"));
				l.setUf(rs.getString("uf"));
				l.setCep(rs.getString("cep"));
				
				lista.add(l);

			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}
	

}
