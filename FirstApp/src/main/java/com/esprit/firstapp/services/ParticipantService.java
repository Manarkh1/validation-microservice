package com.esprit.firstapp.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esprit.firstapp.entities.Participant;
import com.esprit.firstapp.entities.ParticipantWithEquipeDTO;
import com.esprit.firstapp.entities.EquipeDTO;
import com.esprit.firstapp.mappers.ParticipantMappers;
import com.esprit.firstapp.repository.ParticipantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ParticipantService implements IParticipantService {
	@Autowired
	private EquipeClient equipeClient;

	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public ParticipantWithEquipeDTO addParticipant(ParticipantWithEquipeDTO participantDto) {
		participantRepository.save(ParticipantMappers.mapToEntity(participantDto));
		return participantDto;

	}

	@Override
	public List<ParticipantWithEquipeDTO> getAllParticipant() {

		return participantRepository.findAll().stream().map(participant -> ParticipantMappers.mapToDto(participant))
				.collect(Collectors.toList());
	}

	@Override
	public ParticipantWithEquipeDTO getParticipantById(Long id) {
		Participant participant = participantRepository.findById(id).get();

		// OpenFeign
		EquipeDTO equipeDTO = equipeClient.getById(participant.getId_Equipe());

		// RestTemplate
		// StockDTO stockDTO =getById(article.getId_stock());
		return ParticipantMappers.mapToDto(participant, equipeDTO);
	}

	@Override
	public Participant updateParticipant(Long id, Map<String, Object> participant) {
		Participant existingParticipant = participantRepository.findById(id).get();

		if (existingParticipant == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : participant.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingParticipant.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingParticipant, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return participantRepository.save(existingParticipant);
	}

	@Override
	public void deleteParticipantById(Long id) {
		participantRepository.deleteById(id);

	}

	public EquipeDTO getById(String id) {
		String url = "http://localhost:8090/api/getbyid/" + id;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, EquipeDTO.class);
	}

}
