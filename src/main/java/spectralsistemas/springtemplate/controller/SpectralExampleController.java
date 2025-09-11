package spectralsistemas.springtemplate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spectralsistemas.springtemplate.model.SpectralExample;
import spectralsistemas.springtemplate.service.SpectralExampleService;

/**
 * Controller REST para SpectralExample. Todos os direitos reservados à Spectral Sistemas.
 */
@RestController
@RequestMapping("/api/examples")
public class SpectralExampleController {

  @Autowired
  private SpectralExampleService service;

  /**
   * Retorna todos os exemplos
   */
  @GetMapping
  public List<SpectralExample> listarTodos() {
    return service.listarTodos();
  }

  /**
   * Busca exemplo por ID
   */
  @GetMapping("/{id}")
  public ResponseEntity<SpectralExample> buscarPorId(@PathVariable Long id) {
    return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  /**
   * Cria novo exemplo
   */
  @PostMapping
  public SpectralExample criar(@RequestBody SpectralExample exemplo) {
    return service.salvar(exemplo);
  }

  /**
   * Atualiza exemplo existente
   */
  @PutMapping("/{id}")
  public ResponseEntity<SpectralExample> atualizar(@PathVariable Long id, @RequestBody SpectralExample exemplo) {
    return service.buscarPorId(id).map(e -> {
      exemplo.setId(id);
      return ResponseEntity.ok(service.salvar(exemplo));
    }).orElse(ResponseEntity.notFound().build());
  }

  /**
   * Remove exemplo por ID
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> remover(@PathVariable Long id) {
    if (service.buscarPorId(id).isPresent()) {
      service.remover(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
