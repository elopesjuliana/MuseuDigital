package entity;

import java.util.Date;

public class VendaIngresso {
	
	int idVenda;
	int idIngresso;
	int idVisitante;
	Date dataVenda;
	double valorIngresso;
	String formaDePgto;
	double valorRecebido;
	double valorTroco;
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public int getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public double getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	public double getValorTroco() {
		return valorTroco;
	}
	public void setValorTroco(float valorTroco) {
		this.valorTroco = valorTroco;
	}
	public int getIdIngresso() {
		return idIngresso;
	}
	public void setIdIngresso(int idIngresso) {
		this.idIngresso = idIngresso;
	}
	public double getValorIngresso() {
		return valorIngresso;
	}
	public void setValorIngresso(double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}
	public String getFormaDePgto() {
		return formaDePgto;
	}
	public void setFormaDePgto(String formaDePgto) {
		this.formaDePgto = formaDePgto;
	}
	
	

}
