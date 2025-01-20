package com.salesianos.dam.dataAsociaciones.controller;


import com.salesianos.dam.dataAsociaciones.dto.EditCategoryCmd;
import com.salesianos.dam.dataAsociaciones.dto.GetCategoriaDto;
import com.salesianos.dam.dataAsociaciones.model.Categoria;
import com.salesianos.dam.dataAsociaciones.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Categoria/")
@RequiredArgsConstructor
public class CategoriaController {


    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<GetCategoriaDto> getAllCategorias() {
        return categoriaService.findAll()
                .stream().map(GetCategoriaDto::of)
                .toList();
    }

    @GetMapping("{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody EditCategoryCmd nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.save(nuevo));
    }

    @PutMapping("{id}")
    public Categoria edit( @RequestBody EditCategoryCmd aEditar,@PathVariable Long id) {
        return categoriaService.edit(aEditar,id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Categoria> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

