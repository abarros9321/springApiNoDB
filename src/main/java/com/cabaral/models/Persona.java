package com.cabaral.models;

public class Persona {
	
	private long id;
    private  String nombre;
    private String apellido;
    private Integer edad;
    private Integer estado;
    
	public Persona(long id, String nombre, String apellido, Integer edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.estado = 1;
	}
	
	public Persona(long id, String nombre, String apellido, Integer edad, Integer estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.estado = estado;
	}

	

	public void setId(long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public Integer getEstado() {
		return estado;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", estado="
				+ estado + "]";
	}

	
	
}
