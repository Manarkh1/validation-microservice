package com.esprit.firstapp.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.firstapp.entities.EquipeDTO;

@FeignClient(name = "equipe", url = "http://localhost:8090") 
public interface EquipeClient {
	
	 @GetMapping("/equipe/getbyid/{id}")
	    EquipeDTO getById(@PathVariable("id") String id);
	 
	 

}
