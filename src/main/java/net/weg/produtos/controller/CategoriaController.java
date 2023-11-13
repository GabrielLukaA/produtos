package net.weg.produtos.controller;

import lombok.AllArgsConstructor;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.entity.Categoria;
import net.weg.produtos.service.CategoriaService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoriaController {


    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<Collection<Categoria>> buscarTodos() {
        try {
            return new ResponseEntity<>(categoriaService.buscarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/:{id}")
    public ResponseEntity<Categoria> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(categoriaService.buscarUm(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/:{id}")
    public ResponseEntity<Categoria> editar(@RequestBody IDTO obj) {
        try {
            return new ResponseEntity<>(categoriaService.editar(obj), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Categoria> cadastrar(@RequestBody IDTO obj) {
        try {
            return new ResponseEntity<>(categoriaService.cadastrar(obj), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping("/:{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        try {
            categoriaService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
