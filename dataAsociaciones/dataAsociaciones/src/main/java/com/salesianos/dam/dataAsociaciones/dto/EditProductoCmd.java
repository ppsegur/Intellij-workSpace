package com.salesianos.dam.dataAsociaciones.dto;


public record EditProductoCmd(
        String nombre,
        String descripcion,
        double precio,
        Long categoriaId
) {
}