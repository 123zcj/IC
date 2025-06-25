package com.ic.repository;


import com.ic.model.MentaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMentaRepository extends JpaRepository<MentaData, Long> {

}
