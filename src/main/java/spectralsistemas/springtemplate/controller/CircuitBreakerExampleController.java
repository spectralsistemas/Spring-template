package spectralsistemas.springtemplate.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

/**
 * Exemplo de uso do Circuit Breaker com Resilience4j.
 * Endpoint simula falha aleatória para demonstrar o funcionamento do Circuit Breaker.
 * Assinatura: Spectral Sistemas
 */
@RestController
public class CircuitBreakerExampleController {
    private final Random random = new Random();

    /**
     * Endpoint instável, falha aleatoriamente.
     */
    @GetMapping("/unstable-api")
    public String unstableApi() {
        if (random.nextBoolean()) {
            throw new RuntimeException("Falha simulada!");
        }
        return "Sucesso!";
    }

    /**
     * Endpoint protegido pelo Circuit Breaker.
     * Quando o unstableApi falha muito, ativa o fallback.
     */
    @CircuitBreaker(name = "exampleCB", fallbackMethod = "fallback")
    @GetMapping("/cb-test")
    public String cbTest() {
        return unstableApi();
    }

    /**
     * Fallback chamado quando o Circuit Breaker está aberto.
     */
    public String fallback(Throwable t) {
        return "Fallback ativado: " + t.getMessage();
    }
}

