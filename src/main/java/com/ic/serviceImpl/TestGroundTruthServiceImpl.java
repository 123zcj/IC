package com.ic.serviceImpl;

import com.ic.model.TestGroundTruth;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TestGroundTruthServiceImpl {
    public int SaveTestGroundTruth(String url);
    public Page<TestGroundTruth> getAllTruthByPage(int page, int size);
}
