package com.esprit.firstapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
public class ParticipantWithEquipeDTO {
	private Long id;
	private String name;
	private int age;
	private String id_equipe;
	private EquipeDTO equipedto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId_equipe() {
		return id_equipe;
	}
	public void setId_equipe(String id_equipe) {
		this.id_equipe = id_equipe;
	}
	public EquipeDTO getEquipedto() {
		return equipedto;
	}
	public void setEquipedto(EquipeDTO equipedto) {
		this.equipedto = equipedto;
	}
	public ParticipantWithEquipeDTO() {
	}


	
	

}
