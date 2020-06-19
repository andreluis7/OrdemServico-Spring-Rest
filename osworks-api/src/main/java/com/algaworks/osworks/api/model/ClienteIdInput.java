package com.algaworks.osworks.api.model;

import javax.validation.constraints.NotNull;

public class ClienteIdInput {
	
	private Long id;
	
	@NotNull
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
