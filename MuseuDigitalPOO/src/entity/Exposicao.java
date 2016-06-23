package entity;

import java.util.Date;

public class Exposicao {
	
	private int idExposicao;
	//private int idObra;
	private String nomeExposicao;
	private Date dataInicio;
	private Date dataFim;
	public int getIdExposicao() {
		return idExposicao;
	}
	public void setIdExposicao(int idExposicao) {
		this.idExposicao = idExposicao;
	}
//	public int getIdObra() {
//		return idObra;
//	}
//	public void setIdObra(int idObra) {
//		this.idObra = idObra;
//	}
	public String getNomeExposicao() {
		return nomeExposicao;
	}
	public void setNomeExposicao(String nomeExposicao) {
		this.nomeExposicao = nomeExposicao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	@Override
	public String toString() {
		return "Exposicao [idExposicao=" + idExposicao + ", nomeExposicao=" + nomeExposicao
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}
	
		
	
}
