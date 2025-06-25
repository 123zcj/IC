package com.ic.controller;


import com.ic.model.MentaData;
import com.ic.model.TestGroundTruth;
import com.ic.model.TrainGroundTruth;
import com.ic.model.TrainMentaData;
import com.ic.service.TestGroundTruthService;
import com.ic.service.TestMentaDataService;
import com.ic.service.TrainGroundTruthService;
import com.ic.service.TrainMentaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GetDataController {
    @Autowired
    private TrainMentaDataService trainMentaDataService;
    @Autowired
    private TestMentaDataService testMentaDataService;
    @Autowired
    private TestGroundTruthService testGroundTruthService;
    @Autowired
    TrainGroundTruthService trainGroundTruthService;
    @GetMapping("/getalltestmentadata")
    public Page<MentaData> getAllTestMentaData(@RequestParam int page, @RequestParam int size)
    {
        return testMentaDataService.getAllByPage(page, size);
    }

    @GetMapping("/getalltrainmentadata")
    public Page<TrainMentaData> getAllTrainMentaData(@RequestParam int page, @RequestParam int size)
    {
       return trainMentaDataService.getAllByPage(page, size);
    }
    @GetMapping("/getalltestgroundtruth")
    public Page<TestGroundTruth> getAllTestTruth(@RequestParam int page, @RequestParam int size)
    {
        return testGroundTruthService.getAllTruthByPage(page, size);
    }

    @GetMapping("/getalltraingroundtruth")
    public Page<TrainGroundTruth> getAllTrainTruth(@RequestParam int page, @RequestParam int size)
    {
        return trainGroundTruthService.getAllTruthByPage(page, size);
    }


}
