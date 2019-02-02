package br.com.oxentmusic.controller.exception;

public class ErrorPadrao {

	private Long timestamp;

	private Integer status;

	private String msg;

	public ErrorPadrao(Long timestamp, Integer status, String msg) {
		this.timestamp = timestamp;
		this.status = status;
		this.msg = msg;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
