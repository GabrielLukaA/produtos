package net.weg.produtos.controller;

import lombok.AllArgsConstructor;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.entity.Fabricante;
import net.weg.produtos.service.FabricanteService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/manufacturers")
public class FabricanteController {


    private FabricanteService fabricanteService;

    @GetMapping()
    public ResponseEntity<Collection<Fabricante>> buscarTodos() {
        try {
            return new ResponseEntity<>(fabricanteService.buscarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/:{id}")
    public ResponseEntity<Fabricante> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(fabricanteService.buscarUm(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/:{id}")
    public ResponseEntity<Fabricante> editar(@RequestBody IDTO obj) {
        try {
            return new ResponseEntity<>(fabricanteService.editar(obj), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Fabricante> cadastrar(@RequestBody IDTO obj) {
        try {
            return new ResponseEntity<>(fabricanteService.cadastrar(obj), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping("/:{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        try {
            fabricanteService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
