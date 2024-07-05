package com.esprit.secondapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esprit.secondapp.entities.Equipe;

public interface EquipeRepository extends MongoRepository<Equipe, String>{

}
