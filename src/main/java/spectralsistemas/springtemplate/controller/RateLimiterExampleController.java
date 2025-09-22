package spectralsistemas.springtemplate.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exemplo de uso do RateLimiter com Resilience4j. Endpoint limita o número de requisições por segundo. Assinatura:
 * Spectral Sistemas
 */
@RestController
public class RateLimiterExampleController {

  /**
   * Endpoint protegido pelo RateLimiter. Quando o limite é atingido, ativa o fallback.
   */
  @RateLimiter(name = "exampleRL", fallbackMethod = "fallback")
  @GetMapping("/rate-limit-test")
  public String rateLimitTest() {
    return "Requisição aceita!";
  }

  /**
   * Fallback chamado quando o RateLimiter bloqueia a requisição.
   */
  public String fallback(Throwable t) {
    return "Rate limit atingido! Tente novamente em instantes.";
  }
}

