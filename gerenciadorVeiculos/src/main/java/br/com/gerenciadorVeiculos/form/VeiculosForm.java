package br.com.gerenciadorVeiculos.form;

import java.io.IOException;

import javax.validation.constraints.NotEmpty;


import com.sun.istack.NotNull;

import br.com.gerenciadorVeiculos.modelo.Veiculo;

public class VeiculosForm {
	
	@NotNull @NotEmpty 
	private String marca;
	@NotNull @NotEmpty 
	private String modelo;
	@NotNull @NotEmpty 
	private String ano;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Veiculo converter() throws IOException, InterruptedException {
		
		return new Veiculo(marca, modelo, ano);
	}
	 
}
