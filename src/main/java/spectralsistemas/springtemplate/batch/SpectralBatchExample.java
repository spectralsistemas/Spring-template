package spectralsistemas.springtemplate.batch;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Exemplo de uso do Spring Batch/Scheduling. Esta classe agenda uma tarefa simples que imprime uma mensagem a cada
 * minuto.
 *
 * @author Spectral Sistemas
 */
@EnableScheduling
@Component
public class SpectralBatchExample {

  /**
   * Tarefa agendada para rodar a cada 1 minuto. O mét0do imprime uma mensagem no terminal.
   */
  @Scheduled(cron = "0 * * * * *")
  public void reportStatus() {
    System.out.println("[SpectralBatchExample] Tudo bem! Rodando a cada 1 minuto. (Spectral Sistemas)");
  }
}

