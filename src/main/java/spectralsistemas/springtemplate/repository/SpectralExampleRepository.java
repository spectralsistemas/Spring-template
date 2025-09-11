package spectralsistemas.springtemplate.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spectralsistemas.springtemplate.model.SpectralExample;

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

  /**
   * Exemplo de mét0do com paginação (Pageable)
   * Basta remover o comentário para usar
   */
  // Page<SpectralExample> findAll(Pageable pageable);

  /**
   * Exemplo de mét0do com ordenação dinâmica (Sort)
   */
  // List<SpectralExample> findAll(Sort sort);

  /**
   * Exemplo de uso de @QueryHints para otimização de consulta
   */
  // @QueryHints(@javax.persistence.QueryHint(name = QueryHints.HINT_FETCH_SIZE, value = "50"))
  // List<SpectralExample> findByAtivoTrue();

  /**
   * Exemplo de mét0do de atualização com @Modifying e @Transactional
   */
  // @Modifying
  // @Transactional
  // @Query("UPDATE SpectralExample e SET e.ativo = false WHERE e.dataCriacao < :data")
  // int desativarExemplosAntigos(@Param("data") LocalDate data);

  /**
   * Exemplo de uso de @Lock para controle de concorrência
   */
  // @Lock(LockModeType.PESSIMISTIC_WRITE)
  // Optional<SpectralExample> findById(Long id);
}
