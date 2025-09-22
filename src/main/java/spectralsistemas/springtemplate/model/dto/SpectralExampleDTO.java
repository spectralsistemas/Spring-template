package spectralsistemas.springtemplate.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SpectralExampleDTO {

  @NotBlank(message = "O nome não pode ser vazio.")
  @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
  public String nome;

  @NotNull(message = "A data de criação é obrigatória.")
  public java.time.LocalDate dataCriacao;

  public boolean ativo;
}
