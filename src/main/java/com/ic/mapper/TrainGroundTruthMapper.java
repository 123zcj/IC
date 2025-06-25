package com.ic.mapper;

import com.ic.model.TestGroundTruth;
import com.ic.model.TrainGroundTruth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainGroundTruthMapper {

    @Select("SELECT * from Train_ground_truth")
    List<TestGroundTruth> getAllTrainGroundTruth();

    @Insert("INSERT INTO Train_ground_truth(image,type) VALUES (#{image},#{type});")
    int insertTrainGroundTruth(TrainGroundTruth traingroundtruth);
}
