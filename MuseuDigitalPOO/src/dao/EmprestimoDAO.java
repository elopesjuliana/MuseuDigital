package dao;

import java.util.List;

import entity.Emprestimo;
import entity.Exposicao;

public interface EmprestimoDAO {

	public void adicionar(Emprestimo emp);
	public List<Emprestimo> pesquisar(String nome);
}
