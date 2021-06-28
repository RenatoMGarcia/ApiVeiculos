package br.com.gerenciadorVeiculos.consumoApi;

public class ApiAtributosValor {
	
	private String valor;
	private String marca;
	private String modelo;
	private String anomodelo;
	private String combustivel;
	private String codigofipe;
	private String mesreferencia;
	private String tipoveiculo;
	private String siglacombustivel;
	
	
	public ApiAtributosValor() {
		
	}
	
	
	


	public ApiAtributosValor(String valor, String marca, String modelo, String anomodelo, String combustivel,
			String codigofipe, String mesreferencia, String tipoveiculo, String siglacombustivel) {
		this.valor = valor;
		this.marca = marca;
		this.modelo = modelo;
		this.anomodelo = anomodelo;
		this.combustivel = combustivel;
		this.codigofipe = codigofipe;
		this.mesreferencia = mesreferencia;
		this.tipoveiculo = tipoveiculo;
		this.siglacombustivel = siglacombustivel;
	}





	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


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


	public String getAnomodelo() {
		return anomodelo;
	}


	public void setAnomodelo(String anomodelo) {
		this.anomodelo = anomodelo;
	}


	public String getCombustivel() {
		return combustivel;
	}


	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}


	public String getCodigofipe() {
		return codigofipe;
	}


	public void setCodigofipe(String codigofipe) {
		this.codigofipe = codigofipe;
	}


	public String getMesreferencia() {
		return mesreferencia;
	}


	public void setMesreferencia(String mesreferencia) {
		this.mesreferencia = mesreferencia;
	}


	public String getTipoveiculo() {
		return tipoveiculo;
	}


	public void setTipoveiculo(String tipoveiculo) {
		this.tipoveiculo = tipoveiculo;
	}


	public String getSiglacombustivel() {
		return siglacombustivel;
	}


	public void setSiglacombustivel(String siglacombustivel) {
		this.siglacombustivel = siglacombustivel;
	}
	
	
	
	
}
