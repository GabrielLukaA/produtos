package net.weg.produtos.service;

import lombok.AllArgsConstructor;
import net.weg.produtos.model.dto.FabricanteDTO;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.entity.Categoria;
import net.weg.produtos.model.entity.Fabricante;
import net.weg.produtos.repository.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class FabricanteService implements IService<Fabricante, Integer> {



    public static void verificar(Fabricante fabricante)  {
        if (fabricante.getNome() == null || fabricante.getNome() == "") {
            throw new NullPointerException();
        }
    }

    private FabricanteRepository fabricanteRepository;

    @Override
    public Fabricante cadastrar(IDTO obj)  {
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(obj, fabricante);
        if (fabricanteRepository.existsById(fabricante.getId())) {
            throw new DuplicateKeyException("");
        }
        verificar(fabricante);
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public Fabricante editar(IDTO obj)  {
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(obj, fabricante);
        if (!fabricanteRepository.existsById(fabricante.getId())) {
            throw new NoSuchElementException();
        }
        verificar(fabricante);
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public void deletar(Integer integer) {
        if (!fabricanteRepository.existsById(integer)){
            throw new NoSuchElementException();
        }
        fabricanteRepository.deleteById(integer);
    }

    @Override
    public Fabricante buscarUm(Integer integer)  {
        if (!fabricanteRepository.existsById(integer)){
            throw new NoSuchElementException();
        }
        return fabricanteRepository.findById(integer).get();
    }

    @Override
    public Collection<Fabricante> buscarTodos() {
        return fabricanteRepository.findAll();
    }
}
