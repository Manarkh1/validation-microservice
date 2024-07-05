package com.esprit.firstapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Participant;
import com.esprit.firstapp.entities.ParticipantWithEquipeDTO;

public interface IParticipantService {
	
	ParticipantWithEquipeDTO addParticipant(ParticipantWithEquipeDTO participant);

	Participant updateParticipant(Long id, Map<String, Object> participant);

	List<ParticipantWithEquipeDTO> getAllParticipant();

	ParticipantWithEquipeDTO getParticipantById(Long id);

	void deleteParticipantById(Long id);

}
