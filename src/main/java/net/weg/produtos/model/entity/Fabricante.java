package net.weg.produtos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fabricante {

    @Id
    private Integer id;
    @Column(unique = true)

    private Long cnpj;
    @Column(nullable = false)
    private String nome;
    private String descricao;
}
