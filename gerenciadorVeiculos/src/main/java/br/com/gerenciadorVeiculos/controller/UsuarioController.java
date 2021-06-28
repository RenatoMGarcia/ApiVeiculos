package br.com.gerenciadorVeiculos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gerenciadorVeiculos.dto.DetalhaUsuarioDto;
import br.com.gerenciadorVeiculos.dto.UsuarioDto;
import br.com.gerenciadorVeiculos.form.AtualizacaoUsuarioForm;
import br.com.gerenciadorVeiculos.form.UsuariosForm;
import br.com.gerenciadorVeiculos.modelo.Usuario;
import br.com.gerenciadorVeiculos.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioDto> listar(String nomeUsuario) {
		
		if(nomeUsuario == null) {
			List<Usuario> usuarios = usuarioRepository.findAll();
			return UsuarioDto.converter(usuarios);
		}else {
			List<Usuario> usuarios = usuarioRepository.findByNome(nomeUsuario);
			return UsuarioDto.converter(usuarios);
		}
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar (@RequestBody @Valid UsuariosForm form, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
		
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<DetalhaUsuarioDto> detalhar (@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(usuario.isPresent()) {
			return ResponseEntity.ok(new DetalhaUsuarioDto(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuarioForm form) {
		
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
}

