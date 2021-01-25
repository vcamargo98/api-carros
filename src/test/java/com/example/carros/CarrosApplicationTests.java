package com.example.carros;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;


@SpringBootTest
class CarrosApplicationTests {
	
	@Autowired
	private CarroService service;
	
	@Test
	public void teste() {
		
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("Esportivo");
		
		service.insert(carro);	}

}
