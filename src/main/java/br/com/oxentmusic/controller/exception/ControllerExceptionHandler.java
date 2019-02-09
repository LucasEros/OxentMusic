package br.com.oxentmusic.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.oxentmusic.services.exception.AuthorizationException;
import br.com.oxentmusic.services.exception.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorPadrao> notFound(NotFoundException e, HttpServletRequest request) {
		ErrorPadrao err = new ErrorPadrao(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorPadrao> notFound(MethodArgumentNotValidException e, HttpServletRequest request){
		Validacao err = new Validacao(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Erro de Parametros!!");
		for (FieldError erro : e.getBindingResult().getFieldErrors()) {
			ErrorValidacao error = new ErrorValidacao(erro.getField(), erro.getDefaultMessage());
			err.addErrors(error);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ErrorPadrao> autorizationException(AuthorizationException e, HttpServletRequest request) {
		ErrorPadrao err = new ErrorPadrao(System.currentTimeMillis(),HttpStatus.FORBIDDEN.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
}
