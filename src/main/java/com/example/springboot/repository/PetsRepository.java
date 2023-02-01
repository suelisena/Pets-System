package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Pets;

public interface PetsRepository extends JpaRepository<Pets, Long>{

	
}