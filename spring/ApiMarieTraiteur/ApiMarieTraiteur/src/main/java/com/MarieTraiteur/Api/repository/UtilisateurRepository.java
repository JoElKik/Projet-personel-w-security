package com.MarieTraiteur.Api.repository;

import com.MarieTraiteur.Api.entity.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository <Utilisateur,Integer> {
  Optional<Utilisateur> findByEmail(String email);
}
