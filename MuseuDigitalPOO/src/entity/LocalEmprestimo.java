package entity;

public class LocalEmprestimo {
	
	private int idLocalEmprestimo;
	private String nome;
	private String nomeResponsavel;
	private String tel;
	private String email;
	private String lograd;
	private String num;
	private String compl;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public int getIdLocalEmprestimo() {
		return idLocalEmprestimo;
	}
	public void setIdLocalEmprestimo(int idLocalEmprestimo) {
		this.idLocalEmprestimo = idLocalEmprestimo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	@Override
	public String toString() {
		return "LocalEmprestimo [idLocalEmprestimo=" + idLocalEmprestimo + ", nome=" + nome + ", nomeResponsavel="
				+ nomeResponsavel + ", tel=" + tel + ", email=" + email + ", lograd=" + lograd + ", num=" + num
				+ ", compl=" + compl + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep
				+ "]";
	}
		
	
}
