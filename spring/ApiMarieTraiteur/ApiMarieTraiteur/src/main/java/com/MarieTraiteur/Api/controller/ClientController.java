package com.MarieTraiteur.Api.controller;

import com.MarieTraiteur.Api.entity.Client;
import com.MarieTraiteur.Api.entity.Produits;
import com.MarieTraiteur.Api.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
@CrossOrigin(origins = "http://localhost:4200/")
public class ClientController {
  private ClientService clientService;
  public ClientController(ClientService clientService){
    this.clientService = clientService;
  }

  @ResponseStatus(value= HttpStatus.CREATED)
  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public void creer(@RequestBody Client client){
    this.clientService.creer(client);
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public List<Client> rechercher(){
    return this.clientService.rechercher();
  }

  @GetMapping( path = "{id}", produces = APPLICATION_JSON_VALUE)
  public Client lire(@PathVariable int id){
    return this.clientService.lire(id);
  }

  @ResponseStatus(value= HttpStatus.ACCEPTED)
  @DeleteMapping ( path = "{id}")
  public void deleteById(@PathVariable int id){
    this.clientService.deleteById(id);

  }
  @ResponseStatus(value = HttpStatus.NO_CONTENT )
  @PutMapping( path="{id}", consumes = APPLICATION_JSON_VALUE)
  public void modifier(@PathVariable int id,@RequestBody Client client){
    this.clientService.modifier(id,client);
  }
}
