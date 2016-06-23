package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ObraDAO;
import dao.ObraDAOImpl;
import entity.Obra;

public class ObraControl {
	
	private List <Obra> listaGeral = new ArrayList<Obra>();
	private ObraDAO oDao = new ObraDAOImpl();
	
	public void adicionar (Obra o){
		oDao.adicionar(o);
	}
	
	public List<Obra> pesquisar (String nome){
		return oDao.pesquisar(nome);
	}

}
