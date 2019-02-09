package br.com.oxentmusic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.oxentmusic.domain.Usuario;
import br.com.oxentmusic.dto.UsuarioDTO;
import br.com.oxentmusic.repositories.UsuarioRepository;
import br.com.oxentmusic.seguranca.UserSecutiry;
import br.com.oxentmusic.services.exception.AuthorizationException;
import br.com.oxentmusic.services.exception.NotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder cryp;
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario insert(UsuarioDTO user) {
		Usuario userObj = fromDTO(user);
		return repository.save(userObj);
	}
	
	public List<Usuario> readAll() {
		return repository.findAll();
	}
	
	public void update(Usuario user) {
		if(repository.existsById(user.getId())) {
			repository.save(user);
		} else {
			throw new NotFoundException("Usuario nao encontrado!!");
		}
	}

	public Usuario findOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario nao encontrado!!"));
	}
	
	private Usuario fromDTO(UsuarioDTO user) {
		Usuario aux = new Usuario(user.getNome(),user.getEmail(),user.getDataNascimento(),cryp.encode(user.getSenha()));
		return aux;
	}
	
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Usuario findOne() {
		UserSecutiry user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado!!");
		}
		return repository.findById(user.getId()).orElseThrow(() -> new NotFoundException("Usuario nao encontrado!!"));
	}
	
}
