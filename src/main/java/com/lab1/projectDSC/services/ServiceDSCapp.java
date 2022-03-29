package com.lab1.projectDSC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lab1.projectDSC.entities.Subjects;
import com.lab1.projectDSC.repository.SubjectRepository;

@Service
public class ServiceDSCapp {
	
	@Autowired
	private SubjectRepository repository;

	public Subjects save(Subjects s) {
		return this.repository.save(s);
	}

	public List<Subjects> listAllSubjects() {
		return this.repository.findAll();
	}

	public Optional<Subjects> getSubjectsById(Integer id) {
		return this.repository.findById(id);
	}

	public Subjects setSubjectsName(int id, String name) {
		Subjects temp = this.repository.getById(id);
		temp.setName(name);
		return this.repository.save(temp);
	}

	public Subjects setSubjectsNotes(int id, double[] note) {
		Subjects temp = this.repository.getById(id);
		temp.setNote(note);
		return this.repository.save(temp);
	}

	public void deleteSubjects(int id) {
		this.repository.deleteById(id);
	}

	//Falta ordenar lista por nota
	public List<Subjects> listOrderedNotes(){
		List<Subjects> listTemp = listAllSubjects();		
		return null;
	}


}
