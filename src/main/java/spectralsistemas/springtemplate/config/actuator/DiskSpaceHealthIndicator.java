package spectralsistemas.springtemplate.config.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import java.io.File;

/**
 * Health check personalizado para espaço livre em disco. Considera saudável se houver pelo menos 100MB livres no disco.
 * Todos os direitos reservados à Spectral Sistemas.
 */
@Component
public class DiskSpaceHealthIndicator implements HealthIndicator {

  private static final long MIN_FREE_DISK_MB = 100;

  @Override
  public Health health() {
    File root = new File("/");
    long freeDisk = root.getFreeSpace() / (1024 * 1024); // em MB
    if (freeDisk >= MIN_FREE_DISK_MB) {
      return Health.up().withDetail("espacoLivreMB", freeDisk).build();
    } else {
      return Health.down().withDetail("espacoLivreMB", freeDisk)
          .withDetail("erro", "Espaço livre insuficiente no disco").build();
    }
  }
}

