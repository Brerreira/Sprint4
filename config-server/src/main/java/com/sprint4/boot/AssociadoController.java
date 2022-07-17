package com.sprint4.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AssociadoController {

	@Autowired
	AssociadoRepository associadoRepository;
	
	
	@PostMapping("/associados")
	public Associado saveAssociado(@RequestBody Associado associado) {
		return associadoRepository.save(associado);
	}
	
	@PostMapping("associados/partidos")
	public Associado AssociadoFindByPartido(@PathVariable Long partido ) {
		return associadoRepository.getById(partido);
	}
	
	@GetMapping("/associados")
	public List<Associado> GetAllAssociados(){
		return associadoRepository.findAll();
	}
	
	@GetMapping("/associados/{id}")
	public Associado GetAssociadoById(@PathVariable Long id) {
		return associadoRepository.findById(id).get();
	}
	
	@PutMapping("Associados/{id}")
	public Associado updateById(@RequestBody @PathVariable("id")Long id){

	}
	
	@DeleteMapping("associados/{id}")
	public void deleteAssociadoById(@PathVariable Long id) {
		associadoRepository.deleteById(id);
	}
	
	@DeleteMapping("associados/{id}/partidos/{id}")
		public void deleteAssociado(@PathVariable Long id) {
		associadoRepository.delete(Associado);
	}
	
}
