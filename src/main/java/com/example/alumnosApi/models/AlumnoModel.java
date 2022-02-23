package com.example.alumnosApi.models;


import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class AlumnoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String legajo;
    private Integer edad;
    private String dni;
    
    public int obtenerBebidas(int edad) {
		//por default es un mayor de 45
		int cervezas=1;
				
		if(edad >=20 && edad <= 30)
		cervezas=3;
		
		if(edad >=31 && edad <= 45)
			cervezas=2;
				
		return cervezas;
	}
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getFile() {
        return legajo;
    }

    public void setFile(String file) {
        this.legajo = file;
    }

    public Integer getAge() {
        return edad;
    }

    public void setAge(Integer age) {
        this.edad = age;
    }

	public String getSurname() {
		return apellido;
	}

	public void setSurname(String surname) {
		this.apellido = surname;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
    
}
