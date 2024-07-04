package java_lambda_streams_spring.java;

import java_lambda_streams_spring.java.model.DadosEpisodio;
import java_lambda_streams_spring.java.service.ConsumindoAPI;
import java_lambda_streams_spring.java.service.ConverteDados;
import java_lambda_streams_spring.java.model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaLambdaStreamsSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaLambdaStreamsSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumindoAPI = new ConsumindoAPI();
		var json = consumindoAPI.obterDados("https://omdbapi.com/?t=Dexter&y=2006&plot=full&apikey=b05cfd54");
		System.out.println(json);
		var conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
		json = consumindoAPI.obterDados("https://omdbapi.com/?t=Dexter&y=2006&plot=full&apikey=b05cfd54");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		for (int i = 1; i <= dados.totalDeTemporadas(); i++){

		}
		/*// é possivel trazer imagens tambem
		var json = consumindoAPI.obterDados(INSERIR ENDEREÇO DA IMAGEM);
		System.out.println(json)*/;
	}
}
