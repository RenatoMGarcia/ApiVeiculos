package br.com.gerenciadorVeiculos.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.gerenciadorVeiculos.modelo.Usuario;
import br.com.gerenciadorVeiculos.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	@NotNull @NotEmpty @Length(min = 5)
	private String email;
	@NotNull @NotEmpty @Length(min = 5)
	private String cpf;
	private LocalDate dataNascimento;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.getById(id);
		
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setCpf(this.cpf);
		usuario.setDataNascimento(this.dataNascimento);
		
		return usuario;
		
	}

}
