package com.MarieTraiteur.Api.services;


import com.MarieTraiteur.Api.entity.Produits;
import com.MarieTraiteur.Api.repository.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitsService {

  @Autowired
  private ProduitsRepository produitsRepository;

  public ProduitsService(ProduitsRepository produitsRepository) {
    this.produitsRepository = produitsRepository;
  }

  public ProduitsService() {
  }

  public void creer(Produits produits){
    Produits produitsDansLaBDD = this.produitsRepository.findByTitle(produits.getTitle());
    if(produitsDansLaBDD == null ) {
      this.produitsRepository.save(produits);
    }

  }
  public List<Produits> rechercher( ){
    return this.produitsRepository.findAll();
//    List <Produits> produits = ;
//
//
//    if ( produitsDansLaBDD.getType() == null){
//    return this.produitsRepository.findAll();}
//    else { return this.produitsRepository.findByType(produitsDansLaBDD.getType());



  }

  public Produits lire(int id) {
    Optional<Produits> optionalProduits = this.produitsRepository.findById(id);
    return optionalProduits.orElse(null);
  }

  public void  deleteById(int id){
    this.produitsRepository.deleteById(id);
  }

  public void modifier(int id, Produits produits){
    Produits produitsDansLaBDD = this.lire(id);
    if(produitsDansLaBDD.getId() == produits.getId()){
      produitsDansLaBDD.setDescription(produits.getDescription());
      produitsDansLaBDD.setImageurl(produits.getImageurl());
      produitsDansLaBDD.setTitle(produits.getTitle());
      produitsDansLaBDD.setType(produits.getType());
      this.produitsRepository.save(produitsDansLaBDD);

    }
  }

}
