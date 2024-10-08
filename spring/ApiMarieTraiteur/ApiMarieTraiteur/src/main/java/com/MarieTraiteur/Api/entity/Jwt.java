package com.MarieTraiteur.Api.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Jwt")
public class Jwt {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private int id;
  private String valeur;
  private boolean desactive;
  private boolean expire;
  @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE})
  @JoinColumn (name = "utilisateur_id")
  private Utilisateur utilisateur;
}
