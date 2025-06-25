package com.ic.serviceImpl;

import com.ic.model.MentaData;
import com.ic.model.TrainMentaData;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TestMentaDataServiceImpl {
    public int SaveTestMentaData(String url);
    public Page<MentaData> getAllByPage(int page, int size);
}
