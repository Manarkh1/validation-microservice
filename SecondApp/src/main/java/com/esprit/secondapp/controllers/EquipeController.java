package com.esprit.secondapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.secondapp.entities.Equipe;
import com.esprit.secondapp.repository.EquipeRepository;
import com.esprit.secondapp.services.IEquipeService;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
	@Autowired
	private IEquipeService iEquipeService;

	@GetMapping("/getAll")
	public List<Equipe> getAllTutorials() {
		return iEquipeService.getAllEquipe();

	}

	@PostMapping("/save")
	public Equipe save(@RequestBody Equipe stock) {
		return iEquipeService.addEquipe(stock);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") String id) {
		iEquipeService.deleteEquipeById(id);

	}

	@GetMapping("/getbyid/{id}")
	public Equipe GetById(@PathVariable("id") String id) {
		return iEquipeService.getEquipeById(id);
	}

	@PatchMapping("/update/{id}")
	public Equipe patchUpdateStock(@PathVariable String id, @RequestBody Map<String, Object> updates) {
		return iEquipeService.updateEquipe(id, updates);

	}

}
