package com.RegistroPersona.servicio;

import com.RegistroPersona.entidad.Persona;
import com.RegistroPersona.repositorio.RegistroPersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroPersonaServicio {

    private RegistroPersonaRepositorio registropersonaRepositorio;

    @Autowired
    public RegistroPersonaServicio(RegistroPersonaRepositorio registropersonaRepositorio) {
        this.registropersonaRepositorio = registropersonaRepositorio;
    }

    // funcion para guardar Persoana
    public void guardarPersona(Persona persona) {
        this.registropersonaRepositorio.save(persona);
    }

    public List<Persona> verPersonas(){
        return this.registropersonaRepositorio.findAll();
    }

    public boolean eliminarIDPerosna(Integer id){
        try {
            registropersonaRepositorio.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String actualizarIDPersona(Persona persona, Integer id){
        try{
            Persona juego = registropersonaRepositorio.findById(id).get();
            juego.setCedula(persona.getCedula());
            juego.setNombre(persona.getNombre());
            juego.setFechaNacimiento(persona.getFechaNacimiento());
            registropersonaRepositorio.save(juego);
            return "Persona con ID: "+ id +" actualizado";
        }catch (Exception e){
            return  "Perosna con ID: "+ id +" no encontrado";
        }

    }

    public Persona verIDPerosna(Integer id){
        return this.registropersonaRepositorio.findById(id).get();
    }


}
