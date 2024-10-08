package com.MarieTraiteur.Api.controller;

import com.MarieTraiteur.Api.entity.Produits;
import com.MarieTraiteur.Api.services.ProduitsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(path = "produits")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitsControlleur {

  //injection
  private ProduitsService produitsService;

//constructor
  public ProduitsControlleur(ProduitsService produitsService) {
    this.produitsService = produitsService;
  }

  // appel methode selon verbe


  @ResponseStatus(value= HttpStatus.CREATED)
  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public void creer(@RequestBody Produits produits){
    this.produitsService.creer(produits);
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public List<Produits> rechercher(){
    return this.produitsService.rechercher();
  }

  @GetMapping( path = "{id}", produces = APPLICATION_JSON_VALUE)
  public Produits lire(@PathVariable int id){
    return this.produitsService.lire(id);
  }

  @ResponseStatus(value= HttpStatus.ACCEPTED)
  @DeleteMapping ( path = "{id}")
  public void deleteById(@PathVariable int id){
    this.produitsService.deleteById(id);

  }
  @ResponseStatus(value = HttpStatus.NO_CONTENT )
  @PutMapping( path="{id}", consumes = APPLICATION_JSON_VALUE)
  public void modifier(@PathVariable int id,@RequestBody Produits produits){
    this.produitsService.modifier(id,produits);
  }
}
