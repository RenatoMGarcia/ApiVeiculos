package br.com.gerenciadorVeiculos.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gerenciadorVeiculos.modelo.Veiculo;

public class VeiculoDto {
	
	private Long id;
	private String marca;
	private String modeloVeiculo;
	private String ano;
	private BigDecimal preco;
	private boolean diaRodizio; 
	private String rodizio;
	
	public VeiculoDto(Veiculo veiculo) {
		
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modeloVeiculo = veiculo.getModeloVeiculo();
		this.ano = veiculo.getAno();
		this.preco = veiculo.getPreco();
		this.diaRodizio = veiculo.isDiaRodizio();
		this.rodizio = veiculo.getRodizio();
		
	}

	public Long getId() {
		return id;
	}
	


	public String getMarca() {
		return marca;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public String getAno() {
		return ano;
	}
	
	public String getRodizio() {
		return rodizio;
	}
	
	public boolean isDiaRodizio() {
		return diaRodizio;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public static List<VeiculoDto> converter(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());
				
	}


}
