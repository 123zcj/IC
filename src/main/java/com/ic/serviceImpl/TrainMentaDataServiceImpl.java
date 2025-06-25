package com.ic.serviceImpl;


import com.ic.model.MentaData;
import com.ic.model.TrainMentaData;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TrainMentaDataServiceImpl {
    public int SaveTrainMentaData(String url);
    public Page<TrainMentaData> getAllByPage(int page, int size);
}
