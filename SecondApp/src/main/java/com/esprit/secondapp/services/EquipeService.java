package com.esprit.secondapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.secondapp.entities.Equipe;
import com.esprit.secondapp.repository.EquipeRepository;

@Service
public class EquipeService implements IEquipeService {

	@Autowired
	private EquipeRepository equipeRepository;

	@Override
	public Equipe addEquipe(Equipe equipe) {
		equipeRepository.save(equipe);
		return equipe;
	}

	@Override
	public Equipe updateEquipe(String id, Map<String, Object> equipe) {
		Equipe existingEquipe = equipeRepository.findById(id).get();

		if (existingEquipe == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : equipe.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingEquipe.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingEquipe, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return equipeRepository.save(existingEquipe);

	}

	@Override
	public List<Equipe> getAllEquipe() {
		return equipeRepository.findAll();
	}

	@Override
	public Equipe getEquipeById(String id) {
		return equipeRepository.findById(id).get();
	}

	@Override
	public void deleteEquipeById(String id) {
		equipeRepository.deleteById(id);

	}

}
