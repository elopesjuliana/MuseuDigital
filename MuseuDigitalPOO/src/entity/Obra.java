package entity;

import java.util.Date;

public class Obra {
	
	private int idObra;
	private String nome;
	private String autor;
	private String disponivel;
	private String tipo;
	
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
	public String getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Obra [idObra=" + idObra + ", nome=" + nome + ", autor=" + autor + ", disponivel=" + disponivel
				+ ", tipo=" + tipo + "]";
	}
	
	
}
