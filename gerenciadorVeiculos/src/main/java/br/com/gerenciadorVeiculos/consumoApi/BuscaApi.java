package br.com.gerenciadorVeiculos.consumoApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BuscaApi {
	
	private String codigoMarca;
	private String codigoModelo;
	private String codigoAno;
	

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
			.connectTimeout(Duration.ofSeconds(10)).build();

	public String buscarMarca(String marca) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		String stringApi = response.body();

		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		ApiAtributos[] apiAtributos = objectMapper.readValue(stringApi, ApiAtributos[].class);
		
		for (int i = 0; i < apiAtributos.length; i++) {
			
			if(apiAtributos[i].getNome().equals(marca)) {
				codigoMarca = apiAtributos[i].getCodigo();
				
				return codigoMarca;
			}
							
		}
		
		return codigoMarca;

	}
	
	
	public String buscarModelo (String modelo, String codigoMarca) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+codigoMarca+"/modelos"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		String stringApi = response.body();
		JSONObject jasonObject = new JSONObject(stringApi);
        String corrigida = jasonObject.getJSONArray("modelos").toString();

		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		ApiAtributos[] apiAtributos = objectMapper.readValue(corrigida, ApiAtributos[].class);
		
		for (int i = 0; i < apiAtributos.length; i++) {
			
			if(apiAtributos[i].getNome().equals(modelo)) {
				codigoModelo = apiAtributos[i].getCodigo();
				
				return codigoModelo;
			}
							
		}
		
		return codigoModelo;

	}
	
	
	public String buscarAnoVeiculo(String codigoMarca, String codigoModelo, String ano) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+codigoMarca+"/modelos/"+codigoModelo+"/anos"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		String stringApi = response.body();

		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		ApiAtributos[] apiAtributos = objectMapper.readValue(stringApi, ApiAtributos[].class);
		
		for (int i = 0; i < apiAtributos.length; i++) {
			
			if(apiAtributos[i].getNome().equals(ano)) {
				codigoAno = apiAtributos[i].getCodigo();
				
				return codigoAno;
			}
							
		}
		
		return codigoAno;

	}
	
	
	public ApiAtributosValor buscarValor(String codigoMarca, String codigoModelo, String codigoAno) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+codigoMarca+"/modelos/"+codigoModelo+"/anos/"+codigoAno))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		String stringApi = response.body().toLowerCase();

		ObjectMapper objectMapper = new ObjectMapper();
		
		ApiAtributosValor pegaValor = objectMapper.readValue(stringApi, ApiAtributosValor.class);
		
		return pegaValor;
		
	}
	
	
	

}
