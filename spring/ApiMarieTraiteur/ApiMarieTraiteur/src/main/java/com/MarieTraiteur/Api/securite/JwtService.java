package com.MarieTraiteur.Api.securite;


import com.MarieTraiteur.Api.entity.Jwt;
import com.MarieTraiteur.Api.entity.Utilisateur;
import com.MarieTraiteur.Api.repository.JwtRepository;
import com.MarieTraiteur.Api.services.UtilisateurService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@AllArgsConstructor
@Service
public class JwtService {

  public static final String BEARER = "bearer";
  private final String ENCRIPTION_KEY = "608f36e92dc66d97d5933f0e6371493cb4fc05b1aa8f8de64014732472303a7c";
  private UtilisateurService utilisateurService;
  private JwtRepository jwtRepository;

  public Map<String, String> generate(String username) {
    Utilisateur utilisateur = this.utilisateurService.loadUserByUsername(username);
    Map<String, String> jwtMap = this.generateJwt(utilisateur);
    Jwt jwt = Jwt
      .builder()
      .valeur(jwtMap.get(BEARER))
      .desactive(false)
      .expire(false)
      .utilisateur(utilisateur)
      .build();
    this.jwtRepository.save(jwt);
    return jwtMap;
  }
  public Jwt tokenByValeur(String value) {
    return this.jwtRepository.findByValeur(value)
    .orElseThrow(()-> new RuntimeException("Token invalide"));
  }

  public String extractUsername(String token) {
    return this.getClaim(token, Claims::getSubject);
  }

  public boolean isTokenExpired(String token) {
    Date expirationDate = getExpirationDateFromToken(token);
    return expirationDate.before(new Date());
  }

  private Date getExpirationDateFromToken(String token) {
    return this.getClaim(token, Claims::getExpiration);
  }

  private <T> T getClaim(String token, Function<Claims, T> function) { //<T> ou T = type any
    Claims claims = getAllClaims(token);
    return function.apply(claims);
  }

  private Claims getAllClaims(String token) {
    return Jwts.parser()
      .setSigningKey(this.getKey())
      .build()
      .parseClaimsJws(token)
      .getBody();
  }

  private Map<String, String> generateJwt(Utilisateur utilisateur) {
    final long currentTime = System.currentTimeMillis(); //date de création
    final long expirationTime = currentTime + 30 * 60 * 1000; // temps d'expiration 30 min ici

    final Map<String, Object> claims = Map.of(
      "nom", utilisateur.getNom(),
      Claims.EXPIRATION, new Date(expirationTime),
      Claims.SUBJECT, utilisateur.getEmail()
    );

    final String bearer = Jwts.builder()
      .setIssuedAt(new Date(currentTime))
      .setExpiration(new Date(expirationTime))
      .setSubject(utilisateur.getEmail()) //pour qui
      .setClaims(claims) //Claims = info utilisateurs dans le header
      .signWith(getKey(), SignatureAlgorithm.HS256)
      .compact();
    return Map.of(BEARER, bearer);
  }

  private Key getKey() {
    final byte[] decoder = Decoders.BASE64.decode(ENCRIPTION_KEY);
    return Keys.hmacShaKeyFor(decoder);
  }


  public void deconnexion() {
    Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Jwt jwt =this.jwtRepository.findByUtilisateurValideToken(
      utilisateur.getEmail(),
      false,
      false)
      .orElseThrow(() -> new RuntimeException("Token invalide"));
    jwt.setExpire(true);
    jwt.setDesactive(true);
    this.jwtRepository.save(jwt);
  }
}
