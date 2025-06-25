package com.ic.service;

import com.ic.mapper.TestMentaDataMapper;
import com.ic.model.MentaData;
import com.ic.repository.TestMentaRepository;
import com.ic.serviceImpl.TestMentaDataServiceImpl;
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
public class TestMentaDataService implements TestMentaDataServiceImpl {
    @Autowired
    private TestMentaDataMapper testmentadatamapper;
    @Autowired
    private TestMentaRepository testMentaRepository;

    private static final char CSV_DELIMITER = ',';
    private static final int BATCH_SIZE = 1000;
    private static final String filepath = "C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Test_Metadata.csv";

    @Override
    public int SaveTestMentaData(String url){
        int count = 0;
        try {
            FileInputStream fis = new FileInputStream(url);
            InputStreamReader ips = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(ips);
            String line = null;
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",",-1);
                MentaData md = new MentaData(split);
                testmentadatamapper.insertTestMentaData_2(md);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public Page<MentaData> getAllByPage(int page, int size) {
        return testMentaRepository.findAll(PageRequest.of(page, size));
    }






}
