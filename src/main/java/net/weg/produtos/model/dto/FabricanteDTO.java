package net.weg.produtos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FabricanteDTO implements IDTO {

    private Long cnpj;
    private String nome;
    private String descricao;
}
