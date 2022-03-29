package com.lab1.projectDSC.controller;


import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.TextNode;
import com.lab1.projectDSC.entities.Subjects;
import com.lab1.projectDSC.services.ServiceDSCapp;




@RestController
public class ControllerDSCapp {
	
	@Autowired
	private ServiceDSCapp serviceappDSC;

	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Subjects> addSubject(@RequestBody Subjects s){
		return new ResponseEntity<Subjects>(this.serviceappDSC.save(s), HttpStatus.OK);
	}

	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<Collection<Subjects>> getSubjects(){
		return new ResponseEntity<>(this.serviceappDSC.listAllSubjects(), HttpStatus.OK);
	}

	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Optional<Subjects>> getSubjectById(@PathVariable("id") int id){
		return new ResponseEntity<Optional<Subjects>>(this.serviceappDSC.getSubjectsById(id), HttpStatus.OK);
	}

	@PutMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Subjects> setSubjectName(@PathVariable("id") int id, @RequestBody TextNode name){
		return new ResponseEntity<Subjects>(this.serviceappDSC.setSubjectsName(id, name.asText()), HttpStatus.OK);
	}

	@PutMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Subjects> setSubjectNotes(@PathVariable("id") int id, @RequestBody double[] notes){
		return new ResponseEntity<Subjects>(this.serviceappDSC.setSubjectsNotes(id, notes), HttpStatus.OK);
	}

	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Subjects> removeSubject(@PathVariable("id") int id){
		this.serviceappDSC.deleteSubjects(id);
		return ResponseEntity.noContent().build();
	}

	//Retorna todas as disciplinas inseridas no sistema ordenadas pela nota (da maior para a menor) 
	//e o <código de resposta HTTP> (ver https://developer.mozilla.org/en-US/docs/Web/HTTP/Status).
	@GetMapping(" /v1/api/disciplinas/ranking")
	public ResponseEntity<?> getAllSubjectsByNotes(){		
		return new ResponseEntity<>(this.serviceappDSC.listAllSubjects(), HttpStatus.OK);
		//INCOMPLETO
	}


}

