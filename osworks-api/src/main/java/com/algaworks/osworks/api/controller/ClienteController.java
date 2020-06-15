package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		
		cliente1.setId(1L);
		cliente1.setNome("João das neves");
		cliente1.setTelefone("(14) 3333-3333");
		cliente1.setEmail("joaodasneves@gmail.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria das neves");
		cliente2.setTelefone("(14) 4444-4444");
		cliente2.setEmail("mariadasneves@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
	
}
