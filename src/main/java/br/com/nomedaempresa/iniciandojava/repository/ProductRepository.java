package br.com.nomedaempresa.iniciandojava.repository;

import br.com.nomedaempresa.iniciandojava.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
