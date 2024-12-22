package com.MarieTraiteur.Api.controller;

import com.MarieTraiteur.Api.dto.AuthentificationDTO;
import com.MarieTraiteur.Api.entity.Utilisateur;
import com.MarieTraiteur.Api.securite.JwtService;
import com.MarieTraiteur.Api.services.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UtilisateurControlleur {

  private AuthenticationManager authenticationManager;
  private UtilisateurService utilisateurService;
  private JwtService jwtService;

  @PostMapping(path = "inscription")
  public void inscription(@RequestBody Utilisateur utilisateur){
      log.info("inscription");
      this.utilisateurService.inscription(utilisateur);
  }

  @PostMapping(path = "deconnexion")
  public void deconnexion() {
    this.jwtService.deconnexion();
  }

  @PostMapping(path = "connexion")
  public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
    Authentication authenticate = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
    );

    if(authenticate.isAuthenticated()){
       return this.jwtService.generate(authentificationDTO.username());
    }


    return null;
  }
}
