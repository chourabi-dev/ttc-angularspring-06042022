package com.ttcdemospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttcdemospring.entities.Sells;

public interface SellsRepository extends JpaRepository<Sells,Long> {

}
