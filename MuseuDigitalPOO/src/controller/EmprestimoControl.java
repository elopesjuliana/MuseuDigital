package controller;

import java.util.List;

import dao.EmprestimoDAO;
import dao.EmprestimoDAOImpl;
import entity.Emprestimo;

public class EmprestimoControl {
	
		//private List <Emprestimo> listaGeral = new ArrayList<Emprestimo>();
		private EmprestimoDAO empDao = new EmprestimoDAOImpl();
		
		public void adicionar (Emprestimo emp){
			empDao.adicionar(emp);
		}

		public List<Emprestimo> pesquisar(String nome) {
			// TODO Auto-generated method stub
			return empDao.pesquisar(nome);
		}

}
