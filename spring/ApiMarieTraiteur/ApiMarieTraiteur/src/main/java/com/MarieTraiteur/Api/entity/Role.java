package com.MarieTraiteur.Api.entity;

import com.MarieTraiteur.Api.TypeDeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private int id;
  @Enumerated(EnumType.STRING)
  private TypeDeRole libelle;
}
