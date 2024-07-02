package java_lambda_streams_spring.java;

import java_lambda_streams_spring.java.service.ConsumindoAPI;
import java_lambda_streams_spring.java.service.ConverteDados;
import model.DadosSerie;
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
		var json = consumindoAPI.obterDados("http://www.omdbapi.com/?i=tt3896198&apikey=b05cfd54");
		System.out.println(json);
		var conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);

		/*// é possivel trazer imagens tambem
		var json = consumindoAPI.obterDados(INSERIR ENDEREÇO DA IMAGEM);
		System.out.println(json)*/;
	}
}
