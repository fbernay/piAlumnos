package com.example.alumnosApi.services;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alumnosApi.Dtos.DespedidaDto;
import com.example.alumnosApi.models.AlumnoModel;
import com.example.alumnosApi.repositories.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;
    
    public ArrayList<AlumnoModel> obtenerAlumnos(){
    	System.out.println("Obtener todos los alumnos");
        return (ArrayList<AlumnoModel>) alumnoRepository.findAll();
    }
    
  
    public AlumnoModel guardarAlumno(AlumnoModel alumno){
    	System.out.println("Guardar alumno nuevo");
        return alumnoRepository.save(alumno);
    }
    
    public boolean editarAlumno(AlumnoModel alumno)
    {
    	Long id = alumno.getId();
    	if(this.alumnoRepository.existsById(id)) {
    		
    		String nombre = alumno.getName();
    		String apellido = alumno.getSurname();
    		String dni = alumno.getDni();
    		int edad = alumno.getAge();
    		String legajo = alumno.getFile();
    		
    		this.alumnoRepository.actualizarAlumno(nombre, apellido, edad, legajo, dni, id);
    		System.out.println("Alumno actualizado");
    		return true;
    		
    	}
    	System.out.println("Error al actualizar alumno");
    	return false;
    	
    }

    public Optional<AlumnoModel> obtenerPorId(Long id){
    	System.out.println("Buscar alumno por id");
        return alumnoRepository.findById(id);
    }

    public boolean eliminarAlumno(Long id) {
    	System.out.println("Borrar alumno por id");
        try{
            alumnoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
    public DespedidaDto obtenerBebidas(){
    	DespedidaDto despedidaDto=new DespedidaDto();
    	
    	int bebidasTotales=0;
    	System.out.println("Obtener las bebidas necesarias");
        ArrayList<AlumnoModel> listado = (ArrayList<AlumnoModel>) alumnoRepository.findAll();
        
        for(AlumnoModel item : listado)
        {
        bebidasTotales+=item.obtenerBebidas(item.getAge());	
        }
        
        despedidaDto.setAlumnos(listado.size());
        despedidaDto.setBebidas(bebidasTotales);
        
        System.out.println("Bebidas totales: "+bebidasTotales);
        return despedidaDto;
    }


    
}
