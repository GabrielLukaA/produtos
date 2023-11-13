package net.weg.produtos.repository;

import net.weg.produtos.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Boolean existsProdutoByCodigoDeBarras(Long codigoDeBarras);

}
