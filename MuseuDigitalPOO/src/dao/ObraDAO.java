package dao;

import java.util.List;

import entity.Obra;

public interface ObraDAO {
	
	public void adicionar(Obra o);
	public List<Obra> pesquisar (String nome);	

}
