package spectralsistemas.springtemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import spectralsistemas.springtemplate.model.SpectralExample;
import spectralsistemas.springtemplate.repository.SpectralExampleRepository;

/**
 * Service para regras de negócio de SpectralExample.
 * Todos os direitos reservados à Spectral Sistemas.
 */
@Service
public class SpectralExampleService {

    @Autowired
    private SpectralExampleRepository repository;

    /**
     * Retorna todos os exemplos cadastrados
     */
    public List<SpectralExample> listarTodos() {
        return repository.findAll();
    }

    /**
     * Busca um exemplo por ID
     */
    public Optional<SpectralExample> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Salva ou atualiza um exemplo
     */
    public SpectralExample salvar(SpectralExample exemplo) {
        return repository.save(exemplo);
    }

    /**
     * Remove um exemplo por ID
     */
    public void remover(Long id) {
        repository.deleteById(id);
    }
}

