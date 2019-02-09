package br.com.oxentmusic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.oxentmusic.domain.Usuario;
import br.com.oxentmusic.seguranca.UserSecutiry;

@Service
public class UserDetailsSecurityService implements UserDetailsService{

	@Autowired
	private UsuarioService serviceUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = serviceUsuario.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSecutiry(user.getId(),user.getEmail(),user.getSenha(), user.getPerfil());
	}
	
	
}
