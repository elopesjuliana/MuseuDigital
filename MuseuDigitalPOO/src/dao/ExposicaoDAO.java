package dao;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import entity.Exposicao;

public interface ExposicaoDAO {
	
	public void adicionar(Exposicao e);
	public List<Exposicao> pesquisar(String nome);	

}
