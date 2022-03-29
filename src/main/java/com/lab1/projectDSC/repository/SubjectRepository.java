package com.lab1.projectDSC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab1.projectDSC.entities.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Integer>{
	
}
 