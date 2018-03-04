package org.uvsq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uvsq.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	public List<Professor> findByUsername(String username);
}
