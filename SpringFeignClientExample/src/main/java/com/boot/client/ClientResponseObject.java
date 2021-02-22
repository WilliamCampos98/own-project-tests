package com.boot.client;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "horaFecha", "status", "mensaje","path", "object" })
public class ClientResponseObject {
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonProperty("horaFecha")
	private Date horaFecha;
	@JsonProperty("status")
	private HttpStatus status;
	@JsonProperty("mensaje")
	private String mensaje;
	@JsonProperty("path")
	private String path;
	@JsonProperty("object")
	private Object object;

	// constructor
	public ClientResponseObject() {

	}

	public ClientResponseObject(Date date, HttpStatus status, String mensaje, String path, Object object) {
		this.horaFecha = date;
		this.status = status;
		this.mensaje = mensaje;
		this.path = path;
		this.object = object;
	}

	// getters and setters
	public Date getHoraFecha() {
		return horaFecha;
	}

	public void setHoraFecha(Date date) {
		this.horaFecha = date;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	// metodo
	@Override
	public String toString() {
		return "ResponseEntity [horaFecha=" + horaFecha + ", status=" + status + ", mensaje=" + mensaje + ", path="
				+ path + ", object=" + object + "]";
	}
}
