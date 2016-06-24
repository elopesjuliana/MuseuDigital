package dao;

import java.util.List;

import entity.Visitante;

public interface VisitanteDAO {
	
	public void adicionar(Visitante v);
	public List<Visitante> pesquisar (String nome);	

}
