package br.com.gerenciadorVeiculos.consumoApi;

import java.io.IOException;

public class ConsumoApi {

    

    public ApiAtributosValor defineValor(String marca, String modelo, String ano) throws IOException, InterruptedException {

        
       BuscaApi buscaApi = new BuscaApi();
        
        String codigoMarca = buscaApi.buscarMarca(marca);
        
        String codigoModelo = buscaApi.buscarModelo(modelo, codigoMarca);
        
        String codigoAno = buscaApi.buscarAnoVeiculo(codigoMarca, codigoModelo, ano);
        
        ApiAtributosValor objetoVeiculo = buscaApi.buscarValor(codigoMarca, codigoModelo, codigoAno);
        

        return objetoVeiculo;

    }

}
