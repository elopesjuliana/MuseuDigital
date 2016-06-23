package entity;

import java.util.Date;

public class Obra {
	
	private int idObra;
	private String nome;
	private String autor;
	private boolean disponivel;
	private int tipo;
	
	public int getIdObra() {
		return idObra;
	}
	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Obra [idObra=" + idObra + ", nome=" + nome + ", autor=" + autor + ", disponivel=" + disponivel
				+ ", tipo=" + tipo + "]";
	}
	
	
}
