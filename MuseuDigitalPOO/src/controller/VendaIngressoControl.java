package controller;

import dao.VendaIngressoDAO;
import dao.VendaIngressoDAOImpl;
import entity.VendaIngresso;

public class VendaIngressoControl {
	
private VendaIngressoDAO vIngressoDao = new VendaIngressoDAOImpl();
	
	public void adicionar (VendaIngresso vIngresso){
		vIngressoDao.adicionar(vIngresso);
	}

}
