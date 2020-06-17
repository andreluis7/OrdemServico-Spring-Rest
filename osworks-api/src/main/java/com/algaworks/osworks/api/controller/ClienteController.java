package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listar() {
		//return clienteRepository.findByNome("teste");
		//return clienteRepository.findByNomeContaining("a");
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{clienteid}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteid) {
		
		Optional<Cliente> cliente =  clienteRepository.findById(clienteid);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{clienteid}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteid, @RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(clienteid)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteid);
		
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteid}")
	public ResponseEntity<Void> excluir (@PathVariable Long clienteid){
		
		if(!clienteRepository.existsById(clienteid)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(clienteid);
		
		return ResponseEntity.noContent().build();
	}
	
}
