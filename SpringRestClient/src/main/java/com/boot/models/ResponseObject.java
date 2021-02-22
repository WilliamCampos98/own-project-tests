package com.boot.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

//Esta clase es ResponseBody, creo una estandarizacion de respuesta para ciertas peticiones
public class ResponseObject {
	// fecha, hora y minutos de la peticion http
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date horaFecha;
	// el estatus de respuesta
	private HttpStatus status;
	// mensaje de respuesta
	private String mensaje;
	// url de la peticion
	private String path;
	// lo que envio como respuesta a solicitud
	private Object object;

	// constructor
	public ResponseObject() {

	}

	public ResponseObject(Date date, HttpStatus status, String mensaje, String path, Object object) {
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
