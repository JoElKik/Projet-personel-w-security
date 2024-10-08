package com.MarieTraiteur.Api.securite;






import com.MarieTraiteur.Api.services.UtilisateurService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.EnumSet;

import static org.springframework.http.HttpMethod.*;

@CrossOrigin(origins = "http://localhost:8080")
@Configuration
@EnableWebSecurity
public class ConfigurationSecuriteApplication {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
private final JwtFilter jwtFilter;

    public ConfigurationSecuriteApplication(BCryptPasswordEncoder bCryptPasswordEncoder, JwtFilter jwtFilter) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtFilter = jwtFilter;
    }


    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return
        httpSecurity
                    .cors(AbstractHttpConfigurer::disable)
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(authorize ->
                                              authorize
                                                .requestMatchers(POST,"/inscription").permitAll()
                                                .requestMatchers(POST,"/connexion").permitAll()
                                                .requestMatchers(POST,"/deconnexion").permitAll()
                                                .requestMatchers(GET,"/api/produits").permitAll()



                                                .anyRequest().permitAll()
      ).sessionManagement(httpSecuritySessionManagementConfigurer ->
            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

          )

          .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
          .build();
  }



  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return  authenticationConfiguration.getAuthenticationManager();

  }



  @Bean
  public AuthenticationProvider authenticationProvider (UserDetailsService userDetailsService){
    DaoAuthenticationProvider daoAuthenticationProvider = new  DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
    return daoAuthenticationProvider;
  }

}
