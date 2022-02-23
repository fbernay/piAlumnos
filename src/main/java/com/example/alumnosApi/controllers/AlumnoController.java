package com.example.alumnosApi.controllers;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.alumnosApi.Dtos.DespedidaDto;
import com.example.alumnosApi.models.AlumnoModel;
import com.example.alumnosApi.services.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @GetMapping(path="/todos")
    public ArrayList<AlumnoModel> obtenerAlumnos(){
        return alumnoService.obtenerAlumnos();
    }

    @PostMapping(path="/nuevo")
    public AlumnoModel guardarAlumno(@RequestBody AlumnoModel alumno){
        return this.alumnoService.guardarAlumno(alumno);
    }

    @PutMapping(path="/editar")
    public boolean editarAlumno(@RequestBody AlumnoModel alumno){
        return this.alumnoService.editarAlumno(alumno);
    }
    
    @GetMapping( path = "/{id}")
    public Optional<AlumnoModel> obtenerAlumnoPorId(@PathVariable("id") Long id) {
        return this.alumnoService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.alumnoService.eliminarAlumno(id);
        if (ok){
            return "Alumno con id " + id+ " eliminado";
        }else{
            return "No pudo eliminar el alumno con id" + id;
        }
    }
    
    @GetMapping("/bebidas")
    public  DespedidaDto obtenerCervezas(){
    	    	
    	return	alumnoService.obtenerBebidas();
    	 
    }

}
