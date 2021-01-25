package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.carros.api.exception.ObjectNotFoundException;
import com.example.carros.domain.dto.CarroDTO;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository rep;
	
	public List<CarroDTO> getCarros() {
		
		return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
		
	}
	
	
	public CarroDTO getCarroById(Long id){
		Optional<Carro> carro = rep.findById(id);
		return carro.map(CarroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
		
	}	
	

	public List<CarroDTO>getCarroByTipo(String tipo){
		
		return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
	}
	
	public CarroDTO insert(Carro carro) {
		Assert.isNull(carro.getId(),"Não foi possivel inserir o registro");
		
		return CarroDTO.create(rep.save(carro));
	}
	
	 public CarroDTO update(Carro carro, Long id) {
	        Assert.notNull(id,"Não foi possível atualizar o registro");

	        // Busca o carro no banco de dados
	        Optional<Carro> optional = rep.findById(id);
	        if(optional.isPresent()) {
	            Carro db = optional.get();
	            // Copiar as propriedades
	            db.setNome(carro.getNome());
	            db.setTipo(carro.getTipo());
	            System.out.println("Carro id " + db.getId());

	            // Atualiza o carro
	            rep.save(db);

	            return CarroDTO.create(db);
	        } else {
	            return null;
	            //throw new RuntimeException("Não foi possível atualizar o registro");
	        }
	    }
	
	public void delete(Long id) {
		
			rep.deleteById(id);
	
	}
	
	
	public List<Carro> getCarrosFake() {
		
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro(1L,"Porsche"));
		carros.add(new Carro(2L,"BMW"));
		carros.add(new Carro(3L,"Audi"));
		
		return carros;
	}
}
