package br.com.gerenciadorVeiculos.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gerenciadorVeiculos.modelo.Usuario;

public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
