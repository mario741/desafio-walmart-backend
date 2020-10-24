package com.walmart.desafio;

public class BaseResponse {
	private String mensajeRespuesta;
	private Object data;
	private String error;

	public BaseResponse(String mensajeRespuesta, Object data, String error) {
		this.mensajeRespuesta = mensajeRespuesta;
		this.data = data;
		this.error = error;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public Object getData() {
		return data;
	}

	public String getError() {
		return error;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setError(String error) {
		this.error = error;
	}
}