package br.com.oxentmusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.oxentmusic.domain.Usuario;
import br.com.oxentmusic.dto.UsuarioDTO;
import br.com.oxentmusic.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody UsuarioDTO user) {
		return new ResponseEntity<Usuario>(service.insert(user),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> readAll(){
		return new ResponseEntity<List<Usuario>>(service.readAll(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> findOne(@PathVariable Long id) {
		return new ResponseEntity<Usuario>(service.findOne(id),HttpStatus.OK);
	}

}
