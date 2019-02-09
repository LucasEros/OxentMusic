package br.com.oxentmusic.controller.exception;

public class ErrorValidacao {
	
	private String name;
	
	private String msg;

	public ErrorValidacao(String name, String msg) {
		this.name = name;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
