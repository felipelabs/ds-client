package com.felipelabs.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipelabs.dsclient.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
