package com.espe.micro_cursos.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre del proyecto es obligatorio")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "La descripción del proyecto es obligatoria")
    private String descripcion;

    @Column(nullable = false)
    @Min(value = 1, message = "La duración en meses debe ser mayor o igual a 1")
    private int duracionMeses;

    @Column(name = "fecha_inicio", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}