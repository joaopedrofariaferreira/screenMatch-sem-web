package java_lambda_streams_spring.java.principal;

import java_lambda_streams_spring.java.model.DadosSerie;
import java_lambda_streams_spring.java.service.ConsumindoAPI;
import java_lambda_streams_spring.java.service.ConverteDados;

import java.util.Scanner;

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
    }
}
