package de.onsite.quickstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.onsite.quickstart.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}