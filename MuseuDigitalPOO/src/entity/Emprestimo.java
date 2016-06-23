package entity;

import java.util.Date;
import java.util.List;

public class Emprestimo {
	private int idEmprestimo;
	private String localEmprestimoObra;
	private String obraEmprestimo;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	
	
	public String getLocalObraEmprestimo() {
		return localEmprestimoObra;
	}
	public void setLocalObraEmprestimo(String localEmprestimoObra) {
		this.localEmprestimoObra = localEmprestimoObra;
	}
	public String getObraEmprestimo() {
		return obraEmprestimo;
	}
	public void setObraEmprestimo(String obraEmprestimo) {
		this.obraEmprestimo = obraEmprestimo;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	@Override
	public String toString() {
		return "Emprestimo [idEmprestimo=" + idEmprestimo + ", idLocalEmprestimo=" + localEmprestimoObra + ", idObra="
				+ obraEmprestimo + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + "]";
	}
		
	
	
}
