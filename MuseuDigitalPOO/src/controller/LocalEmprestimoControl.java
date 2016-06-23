package controller;

import dao.LocalEmprestimoDAO;
import dao.LocalEmprestimoDAOImpl;
import entity.LocalEmprestimo;

public class LocalEmprestimoControl {
	
		//private List <LocalEmprestimo> listaGeral = new ArrayList<LocalEmprestimo>();
		private LocalEmprestimoDAO lDao = new LocalEmprestimoDAOImpl();
		
		public void adicionar (LocalEmprestimo l){
			lDao.adicionar(l);
		}

}
