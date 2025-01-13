package com.espe.micro_cursos.controllers;

import com.espe.micro_cursos.model.entity.Proyecto;
import com.espe.micro_cursos.services.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Proyecto proyecto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("error: ");
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString().trim());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proyecto));
    }

    @GetMapping
    public List<Proyecto> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<Proyecto> proyectoOptional = service.findById(id);
        if (proyectoOptional.isPresent()) {
            return ResponseEntity.ok().body(proyectoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Proyecto proyecto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("error: ");
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString().trim());
        }
        Optional<Proyecto> proyectoOptional = service.findById(id);
        if (proyectoOptional.isPresent()) {
            Proyecto proyectoDB = proyectoOptional.get();
            proyectoDB.setNombre(proyecto.getNombre());
            proyectoDB.setDescripcion(proyecto.getDescripcion());
            proyectoDB.setDuracionMeses(proyecto.getDuracionMeses());
            proyectoDB.setFechaInicio(proyecto.getFechaInicio());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proyectoDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Optional<Proyecto> proyectoOptional = service.findById(id);
        if (proyectoOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}