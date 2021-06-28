package br.com.gerenciadorVeiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciadorVeiculos.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findByNome(String nomeUsuario);

}
