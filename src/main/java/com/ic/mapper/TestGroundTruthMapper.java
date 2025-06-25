package com.ic.mapper;

import com.ic.model.TestGroundTruth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestGroundTruthMapper {

    @Select("SELECT * from Test_ground_truth")
    List<TestGroundTruth> getAllTestGroundTruth();

    @Insert("INSERT INTO Test_ground_truth(image,type) VALUES (#{image},#{type});")
    int insertTestGroundTruth(TestGroundTruth testgroundtruth);

}
