package br.com.oxentmusic.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class Validacao extends ErrorPadrao{
	
	private List<ErrorValidacao> erros = new ArrayList<ErrorValidacao>();

	
	public Validacao(Long timestamp, Integer status, String msg) {
		super(timestamp, status, msg);
	}
	
	public void addErrors(ErrorValidacao err) {
		erros.add(err);
	}
	
	public List<ErrorValidacao> getErros() {
		return erros;
	}
	
	public void setErros(List<ErrorValidacao> erros) {
		this.erros = erros;
	}

}
