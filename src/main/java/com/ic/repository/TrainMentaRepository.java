package com.ic.repository;

import com.ic.model.TrainMentaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainMentaRepository extends JpaRepository<TrainMentaData,Long> {

}
