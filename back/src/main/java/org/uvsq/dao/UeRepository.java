package org.uvsq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uvsq.entities.Ue;

public interface UeRepository extends JpaRepository<Ue, Long>{
	public List<Ue> findByName(String name);
}
