package br.com.oxentmusic.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.oxentmusic.annotation.NotEqualsEmail;
import br.com.oxentmusic.services.UsuarioService;

public class NotEqualsEmailValidator implements ConstraintValidator<NotEqualsEmail, String> {

	@Autowired
	private UsuarioService service;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return service.findByEmail(value) != null;
	}

}
