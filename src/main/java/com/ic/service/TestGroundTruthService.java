package com.ic.service;

import com.ic.mapper.TestGroundTruthMapper;
import com.ic.model.TestGroundTruth;
import com.ic.repository.TestGrounpTruthRepository;
import com.ic.serviceImpl.TestGroundTruthServiceImpl;
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
public class TestGroundTruthService implements TestGroundTruthServiceImpl {
    @Autowired
    TestGroundTruthMapper testgroundtruthmapper;
    @Autowired
    TestGrounpTruthRepository testGrounpTruthRepository;
    String filepath = "C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Test_GroundTruth.csv";

    @Override
    public int SaveTestGroundTruth(String url) {
        int count=0;
        try {
            FileInputStream fis = new FileInputStream(url);
            InputStreamReader ips = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(ips);
            String line = null;
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",",-1);
                TestGroundTruth gt = new TestGroundTruth(split);
                testgroundtruthmapper.insertTestGroundTruth(gt);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public Page<TestGroundTruth> getAllTruthByPage(int page, int size)
    {
        return testGrounpTruthRepository.findAll(PageRequest.of(page, size));
    }
}
