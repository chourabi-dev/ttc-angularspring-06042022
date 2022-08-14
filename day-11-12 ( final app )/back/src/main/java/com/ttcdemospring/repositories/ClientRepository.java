package com.ttcdemospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttcdemospring.entities.Clients;

public interface ClientRepository extends JpaRepository<Clients,Long> {

}
