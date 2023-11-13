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
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Double medida; //?
    @ManyToOne
    private Fabricante fabricante;



    @ManyToMany
    @Column(nullable = false)
    private Collection<Categoria> categoria;

    @Column(nullable = false)
    private String dataDeValidade;
    @Column(nullable = false)
    private Integer quantidadeNoEstoque;



}
