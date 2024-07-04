package java_lambda_streams_spring.java.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias ("totalSeasons") Integer totalDeTemporadas,
                         @JsonAlias("imdbRating") String avaliacaoIMDB) {
}
