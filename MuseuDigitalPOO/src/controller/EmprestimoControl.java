package controller;

import dao.EmprestimoDAO;
import dao.EmprestimoDAOImpl;
import entity.Emprestimo;

public class EmprestimoControl {
	
		//private List <Emprestimo> listaGeral = new ArrayList<Emprestimo>();
		private EmprestimoDAO empDao = new EmprestimoDAOImpl();
		
		public void adicionar (Emprestimo emp){
			empDao.adicionar(emp);
		}

}
