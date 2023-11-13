package net.weg.produtos.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import net.weg.produtos.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
