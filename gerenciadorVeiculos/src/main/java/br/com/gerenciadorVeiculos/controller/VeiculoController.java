package br.com.gerenciadorVeiculos.controller;

import java.io.IOException;
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


import br.com.gerenciadorVeiculos.dto.VeiculoDto;
import br.com.gerenciadorVeiculos.form.AtualizacaoVeiculoForm;
import br.com.gerenciadorVeiculos.form.VeiculosForm;
import br.com.gerenciadorVeiculos.modelo.Usuario;
import br.com.gerenciadorVeiculos.modelo.Veiculo;
import br.com.gerenciadorVeiculos.repository.UsuarioRepository;
import br.com.gerenciadorVeiculos.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<VeiculoDto> listar(String nomeVeiculo) {
		
			List<Veiculo> veiculos = veiculoRepository.findAll();
			return VeiculoDto.converter(veiculos);	
	}
	
	@PostMapping
    @Transactional
    @RequestMapping("/usuarios/{id}")
	public ResponseEntity<VeiculoDto> cadastrar(@PathVariable Long id, @RequestBody @Valid VeiculosForm form, UriComponentsBuilder uriBuilder) throws IOException, InterruptedException {
		
		Veiculo veiculo = form.converter();
		Usuario usuario = usuarioRepository.findById(id).get();
		veiculo.setProprietario(usuario);
		usuario.getVeiculos().add(veiculo);
        veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> atualizar (@PathVariable Long id, @RequestBody @Valid AtualizacaoVeiculoForm form) {
		
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if(optional.isPresent()) {
			Veiculo veiculo = form.atualizar(id, veiculoRepository);
			return ResponseEntity.ok(new VeiculoDto(veiculo));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if(optional.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	

}
