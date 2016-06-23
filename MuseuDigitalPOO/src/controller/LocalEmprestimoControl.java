package controller;

import java.util.List;

import dao.LocalEmprestimoDAO;
import dao.LocalEmprestimoDAOImpl;
import entity.LocalEmprestimo;

public class LocalEmprestimoControl {
	
		//private List <LocalEmprestimo> listaGeral = new ArrayList<LocalEmprestimo>();
		private LocalEmprestimoDAO lDao = new LocalEmprestimoDAOImpl();
		
		public void adicionar (LocalEmprestimo l){
			lDao.adicionar(l);
		}
		
		public List<LocalEmprestimo> pesquisar (String nome){
			return lDao.pesquisar(nome);
		}

}
