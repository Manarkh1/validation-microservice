package com.esprit.secondapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Equipe;

public interface IEquipeService {

	Equipe addEquipe(Equipe equipe);

	Equipe updateEquipe(String id, Map<String, Object> equipe);

	List<Equipe> getAllEquipe();

	Equipe getEquipeById(String id);

	void deleteEquipeById(String id);

}
