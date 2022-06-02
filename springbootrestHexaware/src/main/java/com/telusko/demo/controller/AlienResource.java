package com.telusko.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.demo.dao.AlienRepository;
import com.telusko.demo.model.Alien;

@RestController
public class AlienResource {
	
	@Autowired
	AlienRepository repo;

	@DeleteMapping("/alien/{id}")
	public String deleteAlient(@PathVariable int id){
		
		Alien a = repo.getById(id);
		repo.delete(a);
		
		return "deleted:"+a.getId();
	}
	
	@PostMapping(path = "/alien", consumes = {"application/json"})
	public Alien addAlien(Alien alien){
		
		repo.save(alien);
		
		return alien;
	}
	
	@GetMapping(path = "/aliens")
	public List<Alien> getAllAliens(){
		List<Alien> aliens = repo.findAll();
		
		
		return aliens;
	}
	
	@PutMapping(path = "/aliens", consumes = {"application/json"})
	public Alien updateAliens(Alien alien){
		repo.save(alien);
		
		
		return alien;
	}
	
	@RequestMapping(path = "/aliens/{id}")
	public Optional<Alien> getAlien(@PathVariable("id")int id){
		
		 Optional<Alien> alien= repo.findById(id);
		return alien;
	}
}
