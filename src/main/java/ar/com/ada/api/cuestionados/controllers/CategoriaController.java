package ar.com.ada.api.cuestionados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.cuestionados.models.request.InfoCategoriaNueva;
import ar.com.ada.api.cuestionados.models.response.GenericResponse;
import ar.com.ada.api.cuestionados.services.*;
import java.util.*;


@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;


    //Crear una categoría   
    @PostMapping("/categorias") 
    public ResponseEntity<?> crearCategoria(@RequestBody InfoCategoriaNueva categoriaInfo){

        GenericResponse respuesta = new GenericResponse();
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaInfo.nombre);
        categoria.setDescripcion(categoriaInfo.descripcion);

        service.crearCategoria(categoria);
        respuesta.isOk = true;
        respuesta.id = categoria.getCategoriaId();
        respuesta.message = "La categoría fue creada con éxito";
        return ResponseEntity.ok(respuesta);
    }


    //Traer todas las categorías
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias (){
        return ResponseEntity.ok(service.traerCategorias());
    }

    @DeleteMapping("/categorias{id}")
    public ResponseEntity<?> borrarCategoria(@PathVariable Integer id){
        service.borrarCategoriaPorId(id);
        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.message = "La categoría fue eliminada con éxito";

        return ResponseEntity.ok(respuesta);

    }


    @PutMapping("/categorias/{id}")
    //public ResponseEntity<GenericResponse> modificarCategoria(@PathVariable Integer id, @RequestBody ){

        //¿Cambiarle la descripción?

    }

    // Trae todas las preguntas de una categoria específica
    @GetMapping("/categorias/{id}/preguntas")
    public ResponseEntity<List<Categoria>> listarPreguntaPorCat (){
        return ResponseEntity.ok(service.listarPreguntaPorCat());
    }

}

