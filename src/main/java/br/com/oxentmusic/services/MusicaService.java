package br.com.oxentmusic.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	public Musica insert(MusicaDTO user) {
		return repository.save(fromDTO(user));
	}

	public List<Musica> readAll() {
		return repository.findAll();
	}

	public void update(Musica user) {
		if (repository.existsById(user.getId())) {
			repository.save(user);
		}
		throw new NotFoundException("Musica não Encontrada!!");
	}

	public void delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
		throw new NotFoundException("Musica não Encontrada!!");
	}

	private String getData() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sdf.format(new Date(System.currentTimeMillis()));
	}

	private Musica fromDTO(MusicaDTO user) {
		Usuario aux = usuarioService.findOne(user.getUsuarioId());
		Musica music = new Musica(user.getNome(), user.getArtista(), user.getGenero(), aux);
		aux.getMusicas().add(music);
		music.setAtual(getData());
		usuarioService.update(aux);
		return music;
	}
}
