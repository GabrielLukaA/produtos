package net.weg.produtos.service;

import lombok.AllArgsConstructor;
import net.weg.produtos.model.dto.FabricanteDTO;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.entity.Categoria;
import net.weg.produtos.model.entity.Fabricante;
import net.weg.produtos.repository.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class FabricanteService implements IService<Fabricante, Integer> {


    private FabricanteRepository fabricanteRepository;

    @Override
    public Fabricante cadastrar(IDTO obj) {
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(obj, fabricante);
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public Fabricante editar(IDTO obj) {
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(obj, fabricante);
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public void deletar(Integer integer) {
        fabricanteRepository.deleteById(integer);
    }

    @Override
    public Fabricante buscarUm(Integer integer) {
        return fabricanteRepository.findById(integer).get();
    }

    @Override
    public Collection<Fabricante> buscarTodos() {
        return fabricanteRepository.findAll();
    }
}
