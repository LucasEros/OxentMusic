package br.com.oxentmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.oxentmusic.domain.Usuario;
import br.com.oxentmusic.services.UsuarioService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<Usuario> findOne() {
		return new ResponseEntity<Usuario>(service.findOne(),HttpStatus.OK);
	}

}
