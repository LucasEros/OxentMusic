package br.com.oxentmusic.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.oxentmusic.annotation.NotEqualsEmail;

public class UsuarioDTO {
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	private String nome;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Email(message = "Email Invalido!")
	@NotEqualsEmail
	private String email;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	private String dataNascimento;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Size(min = 6, message = "Quantidade de digitos insuficiente!")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
