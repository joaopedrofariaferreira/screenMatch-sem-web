package java_lambda_streams_spring.java.service;

public interface IConverteDados {
    /*podemos utilizar o tipo generico para receber uma variavel a qual ainda nao sabemos ok seu tipo,
    dessa forma, inserimos , logo em seguida do parametro, o tipo que queremos que essa classe seja. Seria como
    um esperado
     */
    <T> T obterDados(String json, Class <T> classe);


}
