package com.MarieTraiteur.Api.services;

import com.MarieTraiteur.Api.entity.Client;
import com.MarieTraiteur.Api.entity.Produits;
import com.MarieTraiteur.Api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

@Autowired
  private ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public void creer(Client client){
    Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
    if(clientDansLaBDD == null ) {
      this.clientRepository.save(client);
    }


  }
  public void  deleteById(int id){
    this.clientRepository.deleteById(id);
  }


  public List<Client> rechercher(){
    return this.clientRepository.findAll();
  }

  public Client lire(int id) {
    Optional<Client> optionalClient = this.clientRepository.findById(id);
      return optionalClient.orElse(null);
  }


  public void modifier(int id, Client client){
    Client ClientDansLaBDD = this.lire(id);
    if(ClientDansLaBDD.getId() == client.getId()){
      ClientDansLaBDD.setNom(client.getNom());
      ClientDansLaBDD.setPrenom(client.getPrenom());
      ClientDansLaBDD.setAdresse(client.getAdresse());
      ClientDansLaBDD.setEmail(client.getEmail());
      this.clientRepository.save(ClientDansLaBDD);

    }
  }
}
