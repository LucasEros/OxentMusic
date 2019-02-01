package br.com.oxentmusic.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Musicas")
public class Musica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false , length = 50)
	private String nome;
	
	@Column(name = "artista", nullable = false, length = 50)
	private String artista;
	
	@Column(name = "genero", nullable = false)
	private String genero;
	
	@Column(name = "data_atual")
	private Date atual;
	
	public Musica() {
		
	}
	
	public Musica(Long id, String nome, String artista, String genero, Date atual) {
		this.id = id;
		this.nome = nome;
		this.artista = artista;
		this.genero = genero;
		this.atual = atual;
	}



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

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getAtual() {
		return atual;
	}

	public void setAtual(Date atual) {
		this.atual = atual;
	}
	
	

}
