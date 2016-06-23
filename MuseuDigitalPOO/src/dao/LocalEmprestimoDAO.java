package dao;

import java.util.List;

import entity.LocalEmprestimo;


public interface LocalEmprestimoDAO {
	
	public void adicionar(LocalEmprestimo l);
	public List<LocalEmprestimo> pesquisar (String nome);

}
