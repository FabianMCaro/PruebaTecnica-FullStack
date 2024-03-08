package com.RegistroPersona.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {

    @Id
    private Integer cedula;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false)
    private String  fechaNacimiento;

    public Persona(){}

    public Integer getCedula() {
        return cedula;
    }
    public void setCedula(Integer cdeula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
