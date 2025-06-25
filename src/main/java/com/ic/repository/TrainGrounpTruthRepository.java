package com.ic.repository;

import com.ic.model.TrainGroundTruth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainGrounpTruthRepository extends JpaRepository<TrainGroundTruth,Long> {
}
