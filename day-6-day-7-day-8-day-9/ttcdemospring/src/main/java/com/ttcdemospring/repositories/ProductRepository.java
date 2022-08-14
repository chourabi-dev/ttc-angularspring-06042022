package com.ttcdemospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttcdemospring.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
