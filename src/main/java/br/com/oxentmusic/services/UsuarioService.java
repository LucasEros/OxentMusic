package br.com.oxentmusic.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oxentmusic.domain.Usuario;
import br.com.oxentmusic.dto.UsuarioDTO;
import br.com.oxentmusic.repositories.UsuarioRepository;
import br.com.oxentmusic.services.exception.NotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario insert(UsuarioDTO user) {
		return repository.save(fromDTO(user));
	}
	
	public List<Usuario> readAll() {
		return repository.findAll();
	}
	
	public void update(Usuario user) {
		if (repository.existsById(user.getId())) {
			repository.save(user);
		}
		throw new NotFoundException("Usuario não Encontrada!!");
	}

	public Usuario findOne(Long id) {
		if(repository.existsById(id)) {
			return repository.findById(id).get();
		}
		throw new NotFoundException("Usuario não Encontrada!!");
	}
	
	private Usuario fromDTO(UsuarioDTO user) {
		ModelMapper model = new ModelMapper();
		Usuario aux = model.map(user, Usuario.class);
		return aux;
	}
}
