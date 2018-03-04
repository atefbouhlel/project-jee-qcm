package org.uvsq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uvsq.entities.QCM;

public interface QCMRepository extends JpaRepository<QCM, Long> {

}
