package br.com.oxentmusic.dto;

import javax.validation.constraints.NotEmpty;

public class MusicaDTO {

	@NotEmpty(message = "Preenchimento Obrigatorio")
	private String nomeDaMusica;

	@NotEmpty(message = "Preenchimento Obrigatorio")
	private String nomeDoCantor;

	@NotEmpty(message = "Preenchimento Obrigatorio")
	private String generoDaMusica;

	private Long usuarioId;

	public String getNomeDaMusica() {
		return nomeDaMusica;
	}

	public void setNomeDaMusica(String nomeDaMusica) {
		this.nomeDaMusica = nomeDaMusica;
	}

	public String getNomeDoCantor() {
		return nomeDoCantor;
	}

	public void setNomeDoCantor(String nomeDoCantor) {
		this.nomeDoCantor = nomeDoCantor;
	}

	public String getGeneroDaMusica() {
		return generoDaMusica;
	}

	public void setGeneroDaMusica(String generoDaMusica) {
		this.generoDaMusica = generoDaMusica;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

}
