package com.RegistroPersona.controlador;

import com.RegistroPersona.entidad.Persona;
import com.RegistroPersona.servicio.RegistroPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistroPersonaControlador {

    RegistroPersonaServicio registropersonaServicio;

    @Autowired
    public RegistroPersonaControlador(RegistroPersonaServicio registropersonaServicio) {
        this.registropersonaServicio = registropersonaServicio;
    }

    // guardar persona
    @PostMapping("/guardar")
    public ResponseEntity<String> guardarPersona(@RequestBody Persona persona) {

            this.registropersonaServicio.guardarPersona(persona);
            return ResponseEntity.ok("los datos de la persona se guardaron");

    }

    // listar personas
    @GetMapping("/verPersonas")
    public ResponseEntity<?> verListaPersonas(){
        List<Persona> listaPersosnas = this.registropersonaServicio.verPersonas();

        if(listaPersosnas.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listaPersosnas);
        }
    }

    // eliminar persona por id
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Integer id ){
        boolean eliminado = registropersonaServicio.eliminarIDPerosna(id);
        if(eliminado){
            return ResponseEntity.ok("Persosna con Cudula: "+ id + " Eliminado");
        }else{
            return ResponseEntity.ok("Cedula: "+ id +" no encontrado para eliminar!!");
        }

    }

    // actualizar perosna por id
    @PutMapping(path = "/actualizar/{id}")
    public ResponseEntity<String> actualizarPersona(@RequestBody Persona persona, @PathVariable Integer id){
        String actualizacion= registropersonaServicio.actualizarIDPersona(persona, id);
        return ResponseEntity.ok(actualizacion);
    }


    @GetMapping(path = "/verPerosna/{id}")
    public ResponseEntity<Persona> verpersona(@PathVariable Integer id){
        return ResponseEntity.ok(registropersonaServicio.verIDPerosna(id));
    }


}
