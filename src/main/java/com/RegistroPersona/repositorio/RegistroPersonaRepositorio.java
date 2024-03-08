package com.RegistroPersona.repositorio;

import com.RegistroPersona.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroPersonaRepositorio extends JpaRepository<Persona, Integer> {

}
