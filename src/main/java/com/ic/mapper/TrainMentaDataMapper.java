package com.ic.mapper;


import com.ic.model.TrainMentaData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainMentaDataMapper {

    @Select("SELECT * from Train_menta_data")
    List<TrainMentaData> getAllTrainMentaData();

    @Select("SELECT * from Train_menta_data WHERE image = #{image}")
    TrainMentaData findTrainMentaDataByImage(String image);

    @Select("SELECT * from Train_menta_data WHERE age_approx = #{ageApprox}")
    List<TrainMentaData> findTrainMentaDataByAge(int age_approx);

    @Select("SELECT * from Train_menta_data WHERE sex = #{sex}")
    List<TrainMentaData> findTrainMentaDataBySex(String sex);

    @Insert("INSERT INTO Train_menta_data(image,age_approx) VALUES (#{image},#{ageApprox});")
    int insertTrainMentaData_1(String image,int age_approx);

    @Insert("INSERT INTO Train_menta_data(image,age_approx,anatom_site_general,lesion_id,sex) VALUES (#{image},#{ageApprox},#{anatomSiteGeneral},#{lesionId},#{sex});")
    int insertTrainMentaData_2(TrainMentaData trainmentadata);
}
