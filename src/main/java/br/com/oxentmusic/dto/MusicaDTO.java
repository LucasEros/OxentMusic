package br.com.oxentmusic.dto;

public class MusicaDTO {
	
	private String nome;
	
	private String artista;
	
	private String genero;
	
	private Long usuarioId;
	
	public MusicaDTO(String nome, String artista, String genero, Long usuarioId) {
		this.nome = nome;
		this.artista = artista;
		this.genero = genero;
		this.usuarioId = usuarioId;
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

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}
