package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fornecedor {
	
	private Long id;
	private String produto;
	private String categoria;
	private String Date;
	private String login;
	private String senha;	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDate() {
		
		return Date;
	}
	
	public void setDate(String date) {
		
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date = simpleDateFormat.format(date1);
	}
	
}
