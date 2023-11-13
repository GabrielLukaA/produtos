package net.weg.produtos.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {
    @Id
    private Integer id;
    @Column(unique = true)
    private String nome;
    @JsonIgnore
    @ManyToMany(mappedBy = "categoria")
    private Collection<Produto> produtos;
    private String descricao;
}
