package com.esprit.firstapp.mappers;

import com.esprit.firstapp.entities.Participant;
import com.esprit.firstapp.entities.ParticipantWithEquipeDTO;
import com.esprit.firstapp.entities.EquipeDTO;

public class ParticipantMappers {

	public static ParticipantWithEquipeDTO mapToDto(Participant participant) {
 
		ParticipantWithEquipeDTO participantDTO = ParticipantWithEquipeDTO.builder().id(participant.getId()).name(participant.getName())
				.age(participant.getAge()).id_equipe(participant.getId_Equipe()).build();
		return participantDTO;
	}

	public static ParticipantWithEquipeDTO mapToDto(Participant participant, EquipeDTO equipeDTO) {

		ParticipantWithEquipeDTO participantDTO = ParticipantWithEquipeDTO.builder().id(participant.getId()).name(participant.getName())
				.age(participant.getAge()).id_equipe(participant.getId_Equipe()).equipedto(equipeDTO).build();

		return participantDTO;
	}

	public static Participant mapToEntity(ParticipantWithEquipeDTO participantWithequipeDTO) {
		Participant participant = Participant.builder().id(participantWithequipeDTO.getId()).name(participantWithequipeDTO.getName()).age(participantWithequipeDTO.getAge())
				.id_Equipe(participantWithequipeDTO.getEquipedto().getId()).build();
		return participant;

	}

}
