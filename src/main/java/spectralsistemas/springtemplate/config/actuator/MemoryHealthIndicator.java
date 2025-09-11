package spectralsistemas.springtemplate.config.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Health check personalizado para memória livre. Considera saudável se houver pelo menos 50MB de memória livre. Todos
 * os direitos reservados à Spectral Sistemas.
 */
@Component
public class MemoryHealthIndicator implements HealthIndicator {

  private static final long MIN_FREE_MEMORY_MB = 50;

  @Override
  public Health health() {
    long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024); // em MB
    if (freeMemory >= MIN_FREE_MEMORY_MB) {
      return Health.up().withDetail("memoriaLivreMB", freeMemory).build();
    } else {
      return Health.down().withDetail("memoriaLivreMB", freeMemory).withDetail("erro", "Memória livre insuficiente")
          .build();
    }
  }
}

