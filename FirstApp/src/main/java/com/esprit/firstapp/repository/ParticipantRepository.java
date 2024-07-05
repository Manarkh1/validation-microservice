package com.esprit.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.firstapp.entities.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
