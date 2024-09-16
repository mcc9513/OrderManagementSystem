package org.example.ordermangementsystem.repo;

import org.example.ordermangementsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
