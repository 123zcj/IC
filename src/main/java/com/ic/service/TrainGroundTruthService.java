package com.ic.service;

import com.ic.mapper.TrainGroundTruthMapper;
import com.ic.model.TestGroundTruth;
import com.ic.model.TrainGroundTruth;
import com.ic.repository.TrainGrounpTruthRepository;
import com.ic.serviceImpl.TrainGroundTruthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class TrainGroundTruthService implements TrainGroundTruthServiceImpl {
    @Autowired
    TrainGroundTruthMapper traingroundtruthmapper;
    @Autowired
    TrainGrounpTruthRepository trainGrounpTruthRepository;
    String filepath = "C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Training_GroundTruth.csv";

    @Override
    public int SaveTrainGroundTruth(String url) {
        int count=0;
        try {
            FileInputStream fis = new FileInputStream(url);
            InputStreamReader ips = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(ips);
            String line = null;
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",",-1);
                TrainGroundTruth gt = new TrainGroundTruth(split);
                traingroundtruthmapper.insertTrainGroundTruth(gt);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public Page<TrainGroundTruth> getAllTruthByPage(int page, int size)
    {
        return trainGrounpTruthRepository.findAll(PageRequest.of(page, size));
    }
}
