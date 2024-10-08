package com.MarieTraiteur.Api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Commande")
public class Commande {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private int id;

  @ManyToOne
  private Produits produits;
  @ManyToOne(cascade = CascadeType.ALL)
  private Utilisateur utilisateur;

}
