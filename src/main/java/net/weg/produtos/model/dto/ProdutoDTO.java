package net.weg.produtos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.produtos.model.entity.Categoria;
import net.weg.produtos.model.entity.Fabricante;

import java.util.Collection;

@Data
@AllArgsConstructor
public class ProdutoDTO implements IDTO{
    private Long codigoDeBarras;
    private String nome;
    private Double preco;
    private String descricao;
    private Double peso;
    private Double medida; //?
    private Fabricante fabricante;
    private Collection<Categoria> categoria;
    private String dataDeValidade;
    private Integer quantidadeNoEstoque;
}
