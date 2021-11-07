package com.anhanguera.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "unidade")
	private String unidade;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "cod_barras")
	private String codBarras;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getCod_barras() {
		return codBarras;
	}
	public void setCod_barras(String cod_barras) {
		this.codBarras = cod_barras;
	}
	
	
}
