package net.weg.produtos.service;

import lombok.AllArgsConstructor;
import net.weg.produtos.model.dto.CategoriaDTO;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.entity.Categoria;
import net.weg.produtos.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CategoriaService implements IService<Categoria, Integer> {

    CategoriaRepository categoriaRepository;


    public static void verificar(Categoria categoria)  {
        if (categoria.getNome() == null || categoria.getNome() == "") {
            throw new NullPointerException();
        }
    }

    @Override
    public Categoria cadastrar(IDTO obj)  {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(obj, categoria);
        if (categoriaRepository.existsById(categoria.getId())) {
            throw new DuplicateKeyException("");
        }
        verificar(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria editar(IDTO obj)  {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(obj, categoria);
        if (!categoriaRepository.existsById(categoria.getId())) {
            throw new NoSuchElementException();
        }
        verificar(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deletar(Integer integer) {
        if (!categoriaRepository.existsById(integer)){
            throw new NoSuchElementException();
        }
        categoriaRepository.deleteById(integer);
    }

    @Override
    public Categoria buscarUm(Integer integer)  {
        if (!categoriaRepository.existsById(integer)){
            throw new NoSuchElementException();
        }
        return categoriaRepository.findById(integer).get();
    }

    @Override
    public Collection<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }
}
