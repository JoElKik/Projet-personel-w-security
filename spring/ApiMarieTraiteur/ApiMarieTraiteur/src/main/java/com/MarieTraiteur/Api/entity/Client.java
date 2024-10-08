package com.MarieTraiteur.Api.entity;

import jakarta.persistence.*;

@Entity
@Table(name="CLIENT")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique = true)
  private String nom;
  @Column(unique = true)
  private String prenom;

  private String adresse;
  @Column(unique = true)
  private String email;

  public Client() {
  }

  public Client(int id, String nom, String prenom, String adresse, String email) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
