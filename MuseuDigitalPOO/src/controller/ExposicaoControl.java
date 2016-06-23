package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ExposicaoDAO;
import dao.ExposicaoDAOImpl;
import entity.Exposicao;
import entity.Obra;

public class ExposicaoControl {
	
	private List <Exposicao> listaGeral = new ArrayList<Exposicao>();
	private ExposicaoDAO eDao = new ExposicaoDAOImpl();
	
	public void adicionar (Exposicao e){
		eDao.adicionar(e);
	}
	
	public List<Exposicao> pesquisar (String nome){
		return eDao.pesquisar(nome);
	}

}
