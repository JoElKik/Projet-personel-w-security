package com.MarieTraiteur.Api.repository;

import com.MarieTraiteur.Api.entity.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitsRepository extends JpaRepository <Produits,Integer> {
  Produits findByTitle(String title);
  Produits deleteById( int id);

  List <Produits> findByType(String type);

}
