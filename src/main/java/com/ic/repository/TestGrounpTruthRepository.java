package com.ic.repository;

import com.ic.model.TestGroundTruth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestGrounpTruthRepository extends JpaRepository<TestGroundTruth,Long> {
}
