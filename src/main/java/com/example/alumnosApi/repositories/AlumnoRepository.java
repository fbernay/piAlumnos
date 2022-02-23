package com.example.alumnosApi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import com.example.alumnosApi.models.AlumnoModel;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, Long> {

	
	  @Query(value = "UPDATE Alumnos SET nombre = ?1, apellido=?2, dni=?3, edad=?4, legajo=?5 WHERE id = ?6", nativeQuery = true)
	    Integer actualizarAlumno(String nombre, String apellido, int edad, String legajo, String dni,   Long id);
}