// package com.MarieTraiteur.Api.services;

// import java.time.Instant;
// import java.util.Random;

// import org.springframework.stereotype.Service;

// import com.MarieTraiteur.Api.entity.Utilisateur;
// import com.MarieTraiteur.Api.entity.Validation;
// import com.MarieTraiteur.Api.repository.ValidationRepository;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class ValidationService {

//     private ValidationRepository validationRepository;

//     public void enregistrer(Utilisateur utilisateur){

//         Validation validation = new Validation();
//         validation.setUtilisateur(utilisateur);
//         Instant creation = Instant.now();
//         validation.setCreation(creation);
//         Instant expiration = expiration.plus(10, MINUTES);
//         validation.setExpiration(expiration);

//         Random random = new Random();
//         random.nextInt(99999);
//         // String code = String.format("%06d", randomInteger)
//         validation.setCode(code);
//         this.validationRepository.save(validation);

//     }
// }
