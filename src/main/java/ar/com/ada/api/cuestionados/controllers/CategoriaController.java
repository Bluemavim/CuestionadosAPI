package ar.com.ada.api.cuestionados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.cuestionados.services.CategoriaService;
import ar.com.ada.api.cuestionados.entities.Categoria;
import ar.com.ada.api.cuestionados.models.response.GenericResponse;


@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    //GET /categorias
    @GetMapping("/categorias") //hacer el mapping
    public ResponseEntity<List<Categoria>> traerCategorias() { 
        return ResponseEntity.ok(service.traerCategorias()); 
    }

    //GET Categoría por Id
    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> traerCategoriaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarCategoria(id));
    }

    @PostMapping(value = "/categoria")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria) {
        GenericResponse r = new GenericResponse();

        if (service.crearCategoria(categoria)) {
            r.id = categoria.getCategoriaId();
            r.isOk = true;
            r.message = "Categorúia creada con exito";
            return ResponseEntity.ok(r);
        } else {
            r.isOk = false;
            r.message = "Esta categoría ya esta creada";
            return ResponseEntity.badRequest().body(r);
        }
    }
}

    /*
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
*/


