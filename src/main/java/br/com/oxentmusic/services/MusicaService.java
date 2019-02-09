package br.com.oxentmusic.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oxentmusic.domain.Musica;
import br.com.oxentmusic.domain.Usuario;
import br.com.oxentmusic.dto.MusicaDTO;
import br.com.oxentmusic.repositories.MusicaRepository;
import br.com.oxentmusic.services.exception.NotFoundException;

@Service
public class MusicaService {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MusicaRepository repository;

	public Musica insert(MusicaDTO userobj) {
		
		Usuario aux = usuarioService.findOne(userobj.getUsuarioId());
		Musica music = fromDTO(aux, userobj);
		aux.getBiblioteca().add(music);
		aux.setId(userobj.getUsuarioId());
		
		usuarioService.update(aux);
		return repository.save(music);
	}

	public void update(Musica user) {
		if (repository.existsById(user.getId())) {
			repository.save(user);
		} else {
			throw new NotFoundException("Musica não Encontrada!!");
		}
	}

	public void delete(Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
		} else {
			throw new NotFoundException("Musica não Encontrada!!");
		}
	}

	private String getData() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sdf.format(new Date(System.currentTimeMillis()));
	}

	private Musica fromDTO(Usuario aux,MusicaDTO user) {
		Musica music = new Musica(user.getNomeDoCantor(), user.getNomeDaMusica(), user.getGeneroDaMusica(),aux);
		music.setAtual(getData());
		return music;
	}
}