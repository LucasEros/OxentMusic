package br.com.oxentmusic.services.exception;

public class ListIsEmptyException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ListIsEmptyException(String msg) {
		super(msg);
	}

}
