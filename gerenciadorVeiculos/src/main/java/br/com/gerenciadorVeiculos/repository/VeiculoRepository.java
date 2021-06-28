package br.com.gerenciadorVeiculos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.gerenciadorVeiculos.modelo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	

}
