package com.ic.service;


import com.ic.mapper.TrainMentaDataMapper;
import com.ic.model.MentaData;
import com.ic.model.TrainMentaData;
import com.ic.repository.TrainMentaRepository;
import com.ic.serviceImpl.TrainMentaDataServiceImpl;
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
public class TrainMentaDataService implements TrainMentaDataServiceImpl {

    @Autowired
    private TrainMentaDataMapper trainMentaDataMapper;
    @Autowired
    private TrainMentaRepository trainMentaRepository;
    private static final char CSV_DELIMITER = ',';
    private static final int BATCH_SIZE = 1000;
    private static final String url = "C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Training_Metadata.csv";


    public int SaveTrainMentaData(String filePath){
        int count = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader ips = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(ips);
            String line = null;
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",",-1);
                TrainMentaData md = new TrainMentaData(split);
                trainMentaDataMapper.insertTrainMentaData_2(md);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    public Page<TrainMentaData> getAllByPage(int page, int size) {
        return trainMentaRepository.findAll(PageRequest.of(page, size));
    }


}
