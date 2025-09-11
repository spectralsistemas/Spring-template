package spectralsistemas.springtemplate.config.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuração básica do Spring Security. Protege todas as rotas por padrão, usando autenticação in-memory. Todos os
 * direitos reservados à Spectral Sistemas.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  /**
   * Lista de URLs liberadas sem autenticação. Adicione novas URLs conforme necessário.
   */
  public static final List<String> ALLOWED_URLS = List.of( //
      "/h2-console/**", //
      "/swagger-ui/**", //
      "/api/public/**" //
      // Adicione outras URLs públicas aqui
  );

  /**
   * Define o filtro de segurança padrão, exigindo autenticação para todas as rotas.
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth //
            .requestMatchers(ALLOWED_URLS.toArray(new String[0])) //
            .permitAll() // Libera todas as URLs da lista
            .anyRequest() //
            .authenticated() // Exige autenticação para demais rotas
        ).httpBasic(Customizer.withDefaults()) //
        .csrf(AbstractHttpConfigurer::disable) //
        .headers(headers -> //
            headers.frameOptions(FrameOptionsConfig::disable)); //
    return http.build();
  }

  /**
   * Exemplo de UserDetailsService in-memory, com dois usuários.
   */
  @Bean
  public UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(User.withUsername("admin") //
        .password("{noop}admin123") //
        .roles("ADMIN") //
        .build(), //
        User.withUsername("user") //
            .password("{noop}user123") //
            .roles("USER") //
            .build() //
    );
  }
}
