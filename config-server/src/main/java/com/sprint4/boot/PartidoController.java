package com.sprint4.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PartidoController {

	@Autowired
	PartidoRepository partidoRepository;
	
	
	@PostMapping("/partidos")
	public Partido savePartido(@RequestBody Partido partido) {
		return partidoRepository.save(partido);
	}
	
	
	@GetMapping("/partidos")
	public List<Partido> GetAllPartidos(){
		return partidoRepository.findAll();	
	}
	
	
	@GetMapping("/partidos/{id}")
	public Partido getPartidoById(@PathVariable Long id) {
		return partidoRepository.findById(id).get();
	}
	
	
	@DeleteMapping("/partidos/{id}")
		public void deletePartido(@PathVariable Long id) {
			partidoRepository.deleteById(id);
		}
	
}
