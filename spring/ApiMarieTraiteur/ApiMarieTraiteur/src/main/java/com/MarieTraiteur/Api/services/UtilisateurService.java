package com.MarieTraiteur.Api.services;

import com.MarieTraiteur.Api.TypeDeRole;
import com.MarieTraiteur.Api.entity.Role;
import com.MarieTraiteur.Api.entity.Utilisateur;
import com.MarieTraiteur.Api.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service

public class UtilisateurService implements UserDetailsService {
  private UtilisateurRepository utilisateurRepository;
  private BCryptPasswordEncoder passwordEncoder;
  public void inscription(Utilisateur utilisateur) {
    if (!utilisateur.getEmail().contains("@") ){
      throw new RuntimeException("Email invalide");
    }
    if (!utilisateur.getEmail().contains(".") ){
      throw new RuntimeException("Email invalide");
    }
    Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
    if (utilisateurOptional.isPresent()){
      throw new RuntimeException("Votre mail est déja utilisé");
    }


    String mdpCrypte = this.passwordEncoder.encode(utilisateur.getMdp());
    utilisateur.setMdp(mdpCrypte);

    Role roleUtilisateur = new Role();
    roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
    utilisateur.setRole(roleUtilisateur);
    this.utilisateurRepository.save(utilisateur);


  }

  @Override
  public Utilisateur loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.utilisateurRepository
        .findByEmail(username)
        .orElseThrow(()-> new UsernameNotFoundException("Aucun utilisateur ne correspond a cet identifiant"));

  }
}
