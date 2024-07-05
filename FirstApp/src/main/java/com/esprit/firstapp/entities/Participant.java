package com.esprit.firstapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int age;
	private String id_Equipe;

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

	public String getId_Equipe() {
		return id_Equipe;
	}

	public void setId_Equipe(String id_Equipe) {
		this.id_Equipe = id_Equipe;
	}

	public Participant(Long id, String name, int age, String id_Equipe) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.id_Equipe = id_Equipe;
	}

	public Participant() {
	}

}
