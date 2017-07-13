package com.cabaral.controllers;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabaral.models.Persona;

@RestController
public class PersonaController {
	
    private final AtomicLong counter = new AtomicLong();
    private ArrayList<Persona> personas = new ArrayList<Persona>();
   
    
    @RequestMapping(value="/persona/add")
    public void addPersonas(){
    	Persona perso = new Persona(counter.incrementAndGet(), "alex", "Barros", 21);
        Persona perso1 = new Persona(counter.incrementAndGet(), "alex2", "Barros", 21);
        Persona perso2 = new Persona(counter.incrementAndGet(), "alex", "Barros2", 21);
        
    	personas.add(perso);
    	personas.add(perso1);
    	personas.add(perso2);
    }
    
    @RequestMapping(value="/persona", method=RequestMethod.POST)
    public Persona persona(@RequestParam(value="nombre") String nombre,
    		@RequestParam(value="apellido") String apellido,
    		@RequestParam(value="edad") Integer edad) {
    	
    	Persona persona = new Persona(counter.incrementAndGet(),nombre,apellido,edad);
    	personas.add(persona);
        return persona;
    }
	
    @RequestMapping(value="/persona/all")
    public ArrayList<Persona> getAllpersona() {
    	ArrayList<Persona> personasActivas = new ArrayList<Persona>();
    	for(int i = 0; i<personas.size();i++){
    		if(personas.get(i).getEstado()==1){
    		personasActivas.add(personas.get(i));
    		}
    	}
        return personas;
    }
    
    @RequestMapping(value="/personas")
    public ArrayList<Persona> getAllPersonasActivas() {
    	ArrayList<Persona> personasActivas = new ArrayList<Persona>();
    	for(int i = 0; i<personas.size();i++){
    		if(personas.get(i).getEstado()==1){
    		personasActivas.add(personas.get(i));
    		}
    	}
        return personasActivas;
    }
    
    @RequestMapping(value="/personas", method=RequestMethod.DELETE)
    public ArrayList<Persona> deletePersona(@RequestParam(value="id") Integer id) {
    	for(int i = 0; i<personas.size();i++){
    		if(personas.get(i).getId()==id){
    			personas.get(i).setEstado(0);
    		}
    	}
        return personas;
    }
    
    @RequestMapping(value="/personamodify", method=RequestMethod.POST)
    public String modifyPersona(
    		@RequestParam(value="ids") Long ids,
    		@RequestParam(value="nombre") String nombre,
    		@RequestParam(value="apellido") String apellido,
    		@RequestParam(value="edad") Integer edad) {
    	boolean flag=false;
    	Persona persona = new Persona(ids,nombre,apellido,edad);
    	for(int i = 0; i<personas.size();i++){
    		if(persona.getId()==personas.get(i).getId()){
    			personas.set(i, persona);
    			flag=true;
    		}
    	}
    	if(flag){
    		return persona.toString();	
    	}else{
    		return "error Persona no encontrada";
    	}
        
    }

}
