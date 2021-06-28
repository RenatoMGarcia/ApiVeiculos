package br.com.gerenciadorVeiculos.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.gerenciadorVeiculos.modelo.Veiculo;
import br.com.gerenciadorVeiculos.repository.VeiculoRepository;

public class AtualizacaoVeiculoForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String marca;
	@NotNull @NotEmpty @Length(min = 5)
	private String modelo;
	@NotNull @NotEmpty @Length(min = 5)
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
	
	public Veiculo atualizar (Long id, VeiculoRepository veiculoRepository) {
		
		Veiculo veiculo = veiculoRepository.getById(id);
		
		veiculo.setMarca(this.marca);
		veiculo.setModeloVeiculo(this.modelo);
		veiculo.setAno(this.ano);
		
		return veiculo;
		
	}

}
