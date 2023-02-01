package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Pets;

public interface PetsService {
	
	Pets createPets(Pets pets);
	
	Pets getPetsById(Long petsId);
	
	List<Pets> getAllPets();
	
	Pets updatePets(Pets pets);
	
	void deletePets(Long petsId );
	
}