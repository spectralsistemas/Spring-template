package spectralsistemas.springtemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Exemplo de uso do WebClient sem autenticação para consumir API externa.
 * Todos os direitos reservados à Spectral Sistemas.
 */
@RestController
@RequestMapping("/api/webclient-example")
public class WebClientExampleController {

    @Autowired
    private WebClient webClientNoAuth;

    /**
     * Endpoint que consome uma API pública de números aleatórios e loga o resultado.
     */
    @GetMapping("/random")
    public ResponseEntity<String> getRandomNumber() {
        String url = "https://www.randomnumberapi.com/api/v1.0/random?min=100&max=1000&count=1";
        String result = webClientNoAuth.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(res -> System.out.println("[WebClientExample] Resultado da API random: " + res))
                .block();
        return ResponseEntity.ok(result);
    }
}

