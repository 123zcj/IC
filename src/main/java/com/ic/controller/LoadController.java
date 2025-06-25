package com.ic.controller;

import com.ic.service.TestGroundTruthService;
import com.ic.service.TestMentaDataService;
import com.ic.service.TrainGroundTruthService;
import com.ic.service.TrainMentaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadController {
    @Autowired
    private TestMentaDataService testmentadataservice;
    @Autowired
    private TestGroundTruthService testgroundtruthservice;
    @Autowired
    private TrainMentaDataService trainmentadataservice;
    @Autowired
    private TrainGroundTruthService traingroundtruthservice;


    @GetMapping("/loadtestmentadata")
    public String allTestMentaData()
    {
        int count = testmentadataservice.SaveTestMentaData("C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Test_Metadata.csv");
        System.out.println(count);
        return "Complete Load All Test MentaData!";
    }

    @GetMapping("/loadtestgroundtruth")
    public String allTestGroundTruth()
    {
        int count =testgroundtruthservice.SaveTestGroundTruth("C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Test_GroundTruth.csv");
        System.out.println(count);
        return "Complete Load All Test GroundTruth!";
    }

    @GetMapping("/loadtrainmentadata")
    public String allTrainMentaData()
    {
        int count = trainmentadataservice.SaveTrainMentaData("C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Training_Metadata.csv");
        System.out.println(count);
        return "Complete Load All Trian MentaData!";
    }

    @GetMapping("/loadtraingroundtruth")
    public String allTrainGroundTruth()
    {
        int count =traingroundtruthservice.SaveTrainGroundTruth("C:\\Users\\Administrator\\Desktop\\ISIC_Data\\ISIC_2019_Training_GroundTruth.csv");
        System.out.println(count);
        return "Complete Load All Trian GroundTruth!";
    }
}
