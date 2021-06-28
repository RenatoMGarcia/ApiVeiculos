package br.com.gerenciadorVeiculos.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import br.com.gerenciadorVeiculos.modelo.Usuario;


public class DetalhaUsuarioDto {
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;
	private List<VeiculoDto> veiculos;
	
	public DetalhaUsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.veiculos = new ArrayList<>();
		this.veiculos.addAll(usuario.getVeiculos().stream().map(VeiculoDto::new).collect(Collectors.toList()));
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
	
	
	public List<VeiculoDto> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoDto> veiculos) {
		this.veiculos = veiculos;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}



