package com.example.alumnosApi.Dtos;

public class AlumnoDto {
	
	private String nombre;
	private String apellido;
	private String dni;
	private int edad;
	private String legajo;
	
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	

}
