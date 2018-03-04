package org.uvsq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.uvsq.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
