package com.ati.model;

public class Amigo {

	int id;
	String nombre;
	private int puntuacion;
	
	
	public Amigo(int id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion( int puntuacion) {
		this.puntuacion = puntuacion;
	
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
