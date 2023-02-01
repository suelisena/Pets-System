package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Pets;
import com.example.springboot.repository.PetsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PetsServiceImpl implements PetsService{
	
    @Autowired
	private PetsRepository petsRepository;
	
	@Override
	public Pets createPets(Pets pets) {
		return petsRepository.save(pets);
	}
	
	@Override
	public Pets getPetsById(Long petsId) {
		Optional<Pets> optionalPets = petsRepository.findById(petsId);
		return optionalPets.get();
	}
	
	@Override
	public List<Pets> getAllPets(){
		return petsRepository.findAll();
	}
    
	 @Override
	 public Pets updatePets(Pets pets) {
		 Pets existingPets = petsRepository.findById(pets.getId()).get();
		 existingPets.setId(pets.getId());
		 existingPets.setNome(pets.getNome());
	     existingPets.setRaca(pets.getRaca());
	     existingPets.setEspecie(pets.getEspecie());
	     existingPets.setSexo(pets.getSexo());
	     existingPets.setIdade(pets.getIdade());
	     existingPets.setTamanho(pets.getTamanho());
	     existingPets.setCor(pets.getCor());
	     Pets updatedPets = petsRepository.save(existingPets);
	     return updatedPets;
	     
	 }
	
	 @Override
	 public void deletePets(Long petsId) {
	        petsRepository.deleteById(petsId);
	    }

	 
}
