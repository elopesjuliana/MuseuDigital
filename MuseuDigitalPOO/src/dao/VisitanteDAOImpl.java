package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import entity.Visitante;

public class VisitanteDAOImpl implements VisitanteDAO{

	@Override
	public void adicionar(Visitante v) {

		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "INSERT INTO Visitante (nome, nascimento, tel, email, lograd, num, compl, "
				+ "bairro, cidade, uf, cep, escolaridade, nacionalidade, meioTransporte) " +
					 " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);			
			st.setString(1, v.getNome());
			java.sql.Date d = new java.sql.Date(v.getNascimento().getTime());
			st.setDate(2, d);
			st.setString(3, v.getTel());
			st.setString(4, v.getEmail());
			st.setString(5, v.getLograd() );
			st.setString(6, v.getNum());
			st.setString(7, v.getCompl());
			st.setString(8, v.getBairro());
			st.setString(9, v.getCidade());
			st.setString(10, v.getUf());
			st.setString(11, v.getCep());
			st.setString(12, v.getEscolaridade());
			st.setString(13, v.getNacionalidade());
			st.setString(14, v.getMeioTransporte());
			
			st.executeUpdate();
			
		} catch (SQLException e ){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Visitante> pesquisar(String nome) {

		List <Visitante> lista = new ArrayList<Visitante>();
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "SELECT nome, nascimento, tel, email, lograd, num, compl, "
				+ "bairro, cidade, uf, cep, escolaridade, nacionalidade, meioTransporte FROM Visitante WHERE nome LIKE ?";
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				Visitante v = new Visitante ();
				
				v.setNome(rs.getString("nome"));
				v.setNascimento(rs.getDate("nascimento"));
				v.setTel(rs.getString("tel"));
				v.setEmail(rs.getString("email"));
				v.setLograd(rs.getString("lograd"));
				v.setNum(rs.getString("num"));
				v.setCompl(rs.getString("compl"));
				v.setBairro(rs.getString("bairro"));
				v.setCidade(rs.getString("cidade"));
				v.setUf(rs.getString("uf"));
				v.setCep(rs.getString("cep"));
				v.setEscolaridade(rs.getString("escolaridade"));
				v.setMeioTransporte(rs.getString("meioTransporte"));
				
				lista.add(v);

			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}

}
