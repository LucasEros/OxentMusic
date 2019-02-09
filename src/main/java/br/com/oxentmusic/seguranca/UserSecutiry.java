package br.com.oxentmusic.seguranca;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.oxentmusic.domain.enums.TipoUsuario;

public class UserSecutiry implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSecutiry() {
		
	}
	
	public UserSecutiry(Long id, String email, String senha, Set<TipoUsuario> perfil) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfil.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasRole(TipoUsuario user) {
		return getAuthorities().contains(new SimpleGrantedAuthority(user.getDescricao()));
	}

}
