package entity;

import java.util.Date;

public class Visitante {
	
	int idVisitante;
	private String nome;
	private Date nascimento;
	private String tel;
	private String email;
	private String lograd;
	private String num;
	private String compl;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String escolaridade;
	private String nacionalidade;
	private String meioTransporte;
	
	public int getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLograd() {
		return lograd;
	}
	public void setLograd(String lograd) {
		this.lograd = lograd;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCompl() {
		return compl;
	}
	public void setCompl(String compl) {
		this.compl = compl;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getMeioTransporte() {
		return meioTransporte;
	}
	public void setMeioTransporte(String meioTransporte) {
		this.meioTransporte = meioTransporte;
	}
	@Override
	public String toString() {
		return "Visitante [idVisitante=" + idVisitante + ", nome=" + nome + ", nascimento=" + nascimento + ", tel="
				+ tel + ", email=" + email + ", lograd=" + lograd + ", num=" + num + ", compl=" + compl + ", bairro="
				+ bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", escolaridade=" + escolaridade
				+ ", nacionalidade=" + nacionalidade + ", meioTransporte=" + meioTransporte + "]";
	}

	
	
	

}
