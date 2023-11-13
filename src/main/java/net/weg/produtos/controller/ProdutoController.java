package net.weg.produtos.controller;

import lombok.AllArgsConstructor;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.entity.Produto;
import net.weg.produtos.service.ProdutoService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProdutoController {


    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<Collection<Produto>> buscarTodos(){
        try {
            return new ResponseEntity<>(produtoService.buscarTodos(), HttpStatus.OK);
        }  catch (Exception e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/:{id}")
    public ResponseEntity<Produto> buscarUm(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(produtoService.buscarUm(id), HttpStatus.OK);
        }  catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/:{id}")
    public ResponseEntity<Produto> editar(@RequestBody IDTO obj) {
        try {
            return new ResponseEntity<>(produtoService.editar(obj), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Produto> cadastrar(@RequestBody IDTO obj){
        try {
            return new ResponseEntity<>(produtoService.cadastrar(obj), HttpStatus.OK);
        }  catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
        return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping("/:{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        try {
            produtoService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }  catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
