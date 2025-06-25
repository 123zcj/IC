package com.ic.serviceImpl;

import com.ic.model.TrainGroundTruth;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TrainGroundTruthServiceImpl {
    public int SaveTrainGroundTruth(String url);

    public Page<TrainGroundTruth> getAllTruthByPage(int page,int size);
}
