package com.esprit.firstapp.controllers;

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

import com.esprit.firstapp.entities.Participant;
import com.esprit.firstapp.entities.ParticipantWithEquipeDTO;
import com.esprit.firstapp.services.IParticipantService;
import com.esprit.firstapp.services.EquipeClient;

@RestController
@RequestMapping("/api/participants")

public class ParticipantController {

	@Autowired
	private IParticipantService participantService;

	@GetMapping("/participant")
	public List<ParticipantWithEquipeDTO> getAllTutorials() {
		return participantService.getAllParticipant();

	}

	@PostMapping("/save")
	public ParticipantWithEquipeDTO save(@RequestBody ParticipantWithEquipeDTO participant) {
		return participantService.addParticipant(participant);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		participantService.deleteParticipantById(id);

	}

	@GetMapping("/getbyid/{id}")
	public ParticipantWithEquipeDTO GetById(@PathVariable("id") Long id) {
		return participantService.getParticipantById(id);
	}

	@PatchMapping("/update/{id}")
	public Participant patchUpdateStock(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return participantService.updateParticipant(id, updates);

	}

}
