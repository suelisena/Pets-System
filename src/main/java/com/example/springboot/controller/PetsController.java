package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Pets;
import com.example.springboot.service.PetsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/pets")
public class PetsController {

	@Autowired
	private PetsService petsService;
	
	
	@PostMapping
	public ResponseEntity<Pets> createPets(@RequestBody Pets pets){
		Pets savedPets= petsService.createPets(pets);
		return new ResponseEntity<>(savedPets,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pets> getPetsById(@PathVariable("id") Long petsId){
	     Pets pets = petsService.getPetsById(petsId);
	     return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping
   public ResponseEntity<List<Pets>> getAllPets(){
	   List<Pets> pets = petsService.getAllPets();
	   return new ResponseEntity<>(pets, HttpStatus.OK);
   }
   
    @PutMapping("{id}")
    public ResponseEntity<Pets> updatePets(@PathVariable("id") Long petsId,
    		                               @RequestBody Pets pets){
    	pets.setId(petsId);
    	Pets updatePets = petsService.updatePets(pets);
    	return new ResponseEntity<>(updatePets, HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePets(@PathVariable("id") Long petsId){
    	petsService.deletePets(petsId);
    	return new ResponseEntity<>("Pet deletado com sucesso!", HttpStatus.OK);
    }
	 
}
