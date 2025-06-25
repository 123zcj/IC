package com.ic.controller;

import com.ic.mapper.TestMentaDataMapper;
import com.ic.mapper.TrainMentaDataMapper;
import com.ic.model.MentaData;
import com.ic.model.TrainMentaData;
import com.ic.service.TestMentaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
@RestController
@CrossOrigin
public class testController {
    @Autowired
    private TestMentaDataService testmentadataservice;

    @GetMapping("/test")
    public Page<MentaData> getAll(@RequestParam int page, @RequestParam int size)
    {
        return testmentadataservice.getAllByPage(page, size);
    }

}
