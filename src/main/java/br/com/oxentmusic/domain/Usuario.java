package br.com.oxentmusic.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.oxentmusic.domain.enums.TipoUsuario;

@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_usuario", nullable = false, length = 150)
	private String nome;

	@Column(name = "email_usuario", unique = true, nullable = false, length = 50)
	private String email;

	@Column(name = "dataNascimento_usuario", nullable = false, length = 10)
	private String dataNascimento;

	@JsonIgnore
	@Column(nullable = false)
	private String senha;
	
	@JsonIgnore
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "usuario_perfil")
	private Set<Integer> perfil = new HashSet<Integer>();

	@OneToMany(mappedBy = "userId")
	private List<Musica> biblioteca = new ArrayList<Musica>();

	public Usuario() {

	}

	public Usuario(String nome, String email, String dataNascimento, String senha) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		perfil.add(1);
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

	public Set<TipoUsuario> getPerfil() {
		return perfil.stream().map(x -> TipoUsuario.toEnum(x)).collect(Collectors.toSet());
	}

	public void setPerfil(Set<TipoUsuario> user) {
		this.perfil = user.stream().map(x -> new Integer(x.getCod())).collect(Collectors.toSet());
	}

	public List<Musica> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(List<Musica> biblioteca) {
		this.biblioteca = biblioteca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
