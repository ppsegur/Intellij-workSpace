package com.salesianos.dam.dataAsociaciones.dto;


import com.salesianos.dam.dataAsociaciones.model.Categoria;

public record GetCategoriaDto(Long id, String nombre) {

    public static GetCategoriaDto of(Categoria categoria) {
        return new GetCategoriaDto(categoria.getId(), categoria.getNombre());
    }
}