package controller;

import java.util.ArrayList;
import java.util.List;

import dao.VisitanteDAO;
import dao.VisitanteDAOImpl;
import entity.Visitante;

public class VisitanteControl {
	
	private List <Visitante> listaGeral = new ArrayList<Visitante>();
	private VisitanteDAO vDao = new VisitanteDAOImpl();
	
	public void adicionar (Visitante v){
		vDao.adicionar(v);
	}
	
	public List <Visitante> pesquisar (String nome){
		return vDao.pesquisar(nome);
	}

}
