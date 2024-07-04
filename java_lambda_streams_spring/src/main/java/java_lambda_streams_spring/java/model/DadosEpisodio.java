package java_lambda_streams_spring.java.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Year") String anoDeLancamento,
                            @JsonAlias("Released") String dataDeLancamento,
                            @JsonAlias("imdbRating") String avaliacao) {
}
