package controller;

import dao.IngressoDAO;
import dao.IngressoDAOImpl;
import entity.Ingresso;

public class IngressoControl {
	
private IngressoDAO iDao = new IngressoDAOImpl();
	
	public void adicionar (Ingresso i){
		iDao.adicionar(i);
	}
	

}
