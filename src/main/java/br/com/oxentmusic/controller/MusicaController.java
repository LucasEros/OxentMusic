package br.com.oxentmusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.oxentmusic.domain.Musica;
import br.com.oxentmusic.dto.MusicaDTO;
import br.com.oxentmusic.services.MusicaService;

@Controller
@RequestMapping("/musicas")
public class MusicaController {
	
	@Autowired
	private MusicaService service;
	
	@PostMapping
	public ResponseEntity<Musica> insert(@RequestBody MusicaDTO music){
		return new ResponseEntity<Musica>(service.insert(music), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Musica>> readAll() {
		return new ResponseEntity<List<Musica>>(service.readAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
		ResponseEntity.status(HttpStatus.OK);
	}
}
