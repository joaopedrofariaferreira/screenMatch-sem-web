package java_lambda_streams_spring.java;

import java_lambda_streams_spring.java.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JavaLambdaStreamsSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaLambdaStreamsSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();

		/*List<DadosTemporada> listaDeTemporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalDeTemporadas(); i++){
			json = consumindoAPI.obterDados("https://omdbapi.com/?t=Dexter&y=2006&plot=full&apikey=b05cfd54&season="+i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			listaDeTemporadas.add(dadosTemporada);

		}
		listaDeTemporadas.forEach(System.out::println);*/

	}
}
