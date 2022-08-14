package com.ttcdemospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttcdemospring.entities.Category;
 

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
