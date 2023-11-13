package net.weg.produtos.service;

import lombok.AllArgsConstructor;
import net.weg.produtos.model.dto.CategoriaDTO;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.entity.Categoria;
import net.weg.produtos.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CategoriaService implements IService<Categoria, Integer> {

    CategoriaRepository categoriaRepository;

    @Override
    public Categoria cadastrar(IDTO obj) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(obj, categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria editar(IDTO obj) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(obj, categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deletar(Integer integer) {
        categoriaRepository.deleteById(integer);
    }

    @Override
    public Categoria buscarUm(Integer integer) {
        return categoriaRepository.findById(integer).get();
    }

    @Override
    public Collection<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }
}
