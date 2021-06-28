package br.com.gerenciadorVeiculos.modelo;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.com.gerenciadorVeiculos.consumoApi.ApiAtributosValor;
import br.com.gerenciadorVeiculos.consumoApi.ConsumoApi;

@Entity
public class Veiculo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modeloVeiculo;
	private String ano;
	private BigDecimal preco;
	@ManyToOne
	private Usuario proprietario;
	private boolean rodizioAtivo; 
	private String rodizio;	
	
	
	public Veiculo() {
		
		
		
	}
	
	public Veiculo(String marca, String modelo, String ano) throws IOException, InterruptedException {
		
		this.marca = marca;
		this.modeloVeiculo = modelo;
			
		ConsumoApi consumoApi = new ConsumoApi();
		ApiAtributosValor objetoVeiculo = consumoApi.defineValor(marca, modelo, ano);
		this.preco = new BigDecimal(objetoVeiculo.getValor().substring(3).replace(",",""));		
		String anoString = objetoVeiculo.getAnomodelo();
		this.ano = anoString;
		
		this.rodizio = getDiaRodizio(anoString);
		this.rodizioAtivo = isDiaRodizio(anoString);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public boolean isDiaRodizio() {
		return rodizioAtivo;
	}

	public void setDiaRodizio(boolean diaRodizio) {
		this.rodizioAtivo = diaRodizio;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRodizio() {
		return rodizio;
	}

	
	
	
	public static boolean isDiaRodizio(String ano) {
		LocalDate hoje = LocalDate.now();
		int diaDaSemana = hoje.getDayOfWeek().getValue();

		String ultimoNr = nrFinal(ano);

		boolean status = false;
		  if (ultimoNr == "0" || ultimoNr == "1")
		        status = (diaDaSemana == 1);
		  else if (ultimoNr == "2" || ultimoNr == "3")
		        status = (diaDaSemana == 2);
		  else if (ultimoNr == "4" || ultimoNr == "5")
		        status = (diaDaSemana == 3);
		  else if (ultimoNr == "6" || ultimoNr == "7")
		        status = (diaDaSemana == 4);
		  else if (ultimoNr == "8" || ultimoNr == "9")
		        status = (diaDaSemana == 5);
		        
		   return status;
	}

	private static String nrFinal(String ano) {
		String digitoAno = ano.substring(ano.length() - 1, ano.length());
		  return digitoAno;
	 }

	public static String getDiaRodizio(String ano) {
		String ultimoNr = nrFinal(ano);
		String diaDaSemana = "";
		        
				switch (ultimoNr) {

		        case "0": 
		            diaDaSemana = "segunda-feira";
		            break;
		            
		        case "1": 
		            diaDaSemana = "segunda-feira";
		            break;

		        case "2": 
		            diaDaSemana = "terça-feira";
		            break;

		        case "3": 
		            diaDaSemana = "terça-feira";
		            break;
		            
		        case "4": 
		            diaDaSemana = "quarta-feira";
		            break;
		            
		        case "5": 
		            diaDaSemana = "quarta-feira";
		            break;
		            
		        case "6": 
		            diaDaSemana = "quinta-feira";
		            break;
		            
		        case "7": 
		            diaDaSemana = "quinta-feira";
		            break;

		        case "8": 
		            diaDaSemana = "sexta-feira";
		            break;
		        
			    case "9": 
		            diaDaSemana = "sexta-feira";
		            break;
		        }
    
		        return diaDaSemana;
		    }


}


