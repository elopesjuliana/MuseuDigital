package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.VendaIngresso;

public class VendaIngressoDAOImpl implements VendaIngressoDAO {

	@Override
	public void adicionar(VendaIngresso vIngresso) {
		
		Connection con = (Connection) JDBCUtil.getInstancia().openConnection();
		String sql = "INSERT INTO VendaIngresso (idVisitante, dataVenda, valorIngresso, formaDePgto, valorRecebido) " +
					 " VALUES (?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			
			st.setInt(1, vIngresso.getIdVisitante());
			java.sql.Date d = new java.sql.Date(vIngresso.getDataVenda().getTime());
			st.setDate(2, d);
			st.setDouble(3, vIngresso.getValorIngresso());
			st.setString(4, vIngresso.getFormaDePgto());
			st.setDouble(5, vIngresso.getValorRecebido());
			//st.setDouble(5, vIngresso.getValorTroco());
			
			st.executeUpdate();
			
		} catch (SQLException s ){
			s.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		
	}

}
