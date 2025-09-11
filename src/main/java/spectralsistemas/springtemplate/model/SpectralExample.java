package spectralsistemas.springtemplate.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Exemplo de uso do Lombok na classe SpectralExample.
 * Todos os direitos reservados à Spectral Sistemas.
 */
@Entity // Torna a classe uma entidade JPA
@Table(name = "spectral_example") // Define o nome da tabela
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder // Permite construção de objetos usando o padrão Builder
@NoArgsConstructor // Gera construtor sem argumentos
@AllArgsConstructor // Gera construtor com todos os argumentos
public class SpectralExample {

  /**
   * Identificador único do exemplo
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Nome do exemplo
   */
  private String nome;

  /**
   * Data de criação do exemplo
   */
  private LocalDate dataCriacao;

  /**
   * Status do exemplo
   */
  private boolean ativo;

  /**
   * Campo calculado, não será incluído em equals/hashCode/toString
   */
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Transient // Não será persistido no banco
  private String campoTemporario;

  /**
   * Mét0do de exemplo usando @SneakyThrows para tratar exceções checadas sem declarar no mét0do.
   */
  // @SneakyThrows removido para evitar problemas em entidades JPA
  public void metodoComExcecao() throws Exception {
    throw new Exception("Exemplo de exceção lançada");
  }

  // Mét0do sincronizado removido para evitar problemas de mapeamento JPA
}
