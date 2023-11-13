package net.weg.produtos.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue( strategy = GenerationType.TABLE)
    private Integer id;
    @Column(unique = true)
    private Long codigoDeBarras;
    private String nome;
    private Double preco;
    private String descricao;

    private Double peso;
    private Double medida; //?
    @ManyToOne
    private Fabricante fabricante;



    @ManyToMany
    private Collection<Categoria> categoria;


    private String dataDeValidade;
    private Integer quantidadeNoEstoque;



}
