package java_lambda_streams_spring.java.principal;

import java_lambda_streams_spring.java.model.DadosEpisodio;
import java_lambda_streams_spring.java.model.DadosSerie;
import java_lambda_streams_spring.java.service.ConsumindoAPI;
import java_lambda_streams_spring.java.service.ConverteDados;
import java_lambda_streams_spring.java.model.DadosTemporada;
import org.springframework.beans.factory.ListableBeanFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    //constantes
    private static final String ENDERECO = "https://omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=b05cfd54";
    private Scanner scanner = new Scanner(System.in);
    private ConsumindoAPI consumindoAPI = new ConsumindoAPI();
    private ConverteDados conversor = new ConverteDados();
    public void exibirMenu(){
        System.out.println("****** Digite o nome da serie que deseja consultar ******");
        var nomeSerie = scanner.nextLine();
        var json = consumindoAPI.obterDados(ENDERECO+ nomeSerie.replace(" ","+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> listaDeTemporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalDeTemporadas(); i++){
			json = consumindoAPI.obterDados("https://omdbapi.com/?t=Dexter&y=2006&plot=full&apikey=b05cfd54&season="+i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			listaDeTemporadas.add(dadosTemporada);

		}
		listaDeTemporadas.forEach(System.out::println);

        /*for (int i =0; i < dados.totalDeTemporadas(); i++){
            List<DadosEpisodio> episodiosTemporada = listaDeTemporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++){
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }*/

        listaDeTemporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodioList = listaDeTemporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());
        System.out.println("****** Top 5 episódios ******");

        dadosEpisodioList.stream()
                .filter(e ->! e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);
    }

}
