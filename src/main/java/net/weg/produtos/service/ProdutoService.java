package net.weg.produtos.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.produtos.model.dto.FabricanteDTO;
import net.weg.produtos.model.dto.IDTO;
import net.weg.produtos.model.dto.ProdutoDTO;
import net.weg.produtos.model.entity.Fabricante;
import net.weg.produtos.model.entity.Produto;
import net.weg.produtos.repository.ProdutoRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ProdutoService implements IService<Produto, Integer> {
    ProdutoRepository produtoRepository;

    public void verificar(Produto produto) {

        if (produto.getCodigoDeBarras()==null || produto.getDataDeValidade() == null || produto.getFabricante() == null || produto.getCategoria() == null ||  produto.getNome() == null || produto.getNome() == "" || produto.getPreco()<=0 || produto == null || produto.getPeso() <=0 || produto.getMedida()<=0){
            throw  new NullPointerException();
        }

    }

    @Override
    public Produto cadastrar(IDTO obj)  {
        Produto produto = new Produto();
        BeanUtils.copyProperties(obj, produto);
        verificar(produto);
        if (produtoRepository.existsProdutoByCodigoDeBarras(produto.getCodigoDeBarras())){
            throw new DuplicateKeyException("");
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Produto editar(IDTO obj)  {
        Produto produto = new Produto();
        BeanUtils.copyProperties(obj, produto);
        verificar(produto);
        if (!produtoRepository.existsProdutoByCodigoDeBarras(produto.getCodigoDeBarras())){
            throw new NoSuchElementException();
        }
        return produtoRepository.save(produto);
    }

    @Override
    public void deletar(Integer integer)  {
        if (!produtoRepository.existsById(integer)){
            throw new NoSuchElementException();
        }
        produtoRepository.deleteById(integer);
    }

    @Override
    public Produto buscarUm(Integer integer)  {
        if (!produtoRepository.existsById(integer)){
            throw new NoSuchElementException();
        }
        return produtoRepository.findById(integer).get();
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }
}
