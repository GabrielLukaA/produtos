package net.weg.produtos.service;

import net.weg.produtos.model.dto.IDTO;

import java.util.Collection;

public interface IService<T,ID> {
    T cadastrar(IDTO obj);
    T editar(IDTO obj);
    void deletar(ID id);
    T buscarUm(ID id);
    Collection<T> buscarTodos();

}
