package com.example.carros.domain.dto;

import com.example.carros.domain.Carro;
import org.modelmapper.ModelMapper;

public class CarroDTO {
	
	private Long id;
	private String nome;
	private String tipo;
	
	
	public static CarroDTO create(Carro carro) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(carro,  CarroDTO.class);
	}
	

//	
//	public CarroDTO(Long id, String nome, String tipo) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.tipo = tipo;
//	}
//
//	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
