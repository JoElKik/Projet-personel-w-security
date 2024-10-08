package com.MarieTraiteur.Api.repository;

import com.MarieTraiteur.Api.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
  Client findByEmail(String email);
}
