package spectralsistemas.springtemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuração de beans WebClient reutilizáveis. Um com autenticação básica e outro sem autenticação. Todos os direitos
 * reservados à Spectral Sistemas.
 */
@Configuration
public class WebClientConfig {

  @Value("${webclient.auth.username:usuario}")
  private String username;

  @Value("${webclient.auth.password:senha}")
  private String password;

  /**
   * WebClient sem autenticação.
   */
  @Bean
  public WebClient webClientNoAuth() {
    return WebClient.builder().build();
  }

  /**
   * WebClient com autenticação básica.
   */
  @Bean
  public WebClient webClientBasicAuth() {
    return WebClient.builder().defaultHeaders(headers -> headers.setBasicAuth(username, password)).build();
  }
}

