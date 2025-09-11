package spectralsistemas.springtemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spectralsistemas.springtemplate.model.SpectralExample;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository JPA para SpectralExample. Todos os direitos reservados à Spectral Sistemas.
 */
@Repository
public interface SpectralExampleRepository extends JpaRepository<SpectralExample, Long> {

    /**
     * Busca exemplos pelo nome usando o padrão JPA (query derivada)
     */
    List<SpectralExample> findByNome(String nome);

    /**
     * Busca exemplos ativos usando JPQL
     */
    @Query("SELECT e FROM SpectralExample e WHERE e.ativo = true")
    List<SpectralExample> buscarExemplosAtivos();

    /**
     * Busca exemplos criados após uma data usando Native Query
     */
    @Query(value = "SELECT * FROM spectral_example WHERE data_criacao > :data", nativeQuery = true)
    List<SpectralExample> buscarCriadosDepois(@Param("data") LocalDate data);
}
