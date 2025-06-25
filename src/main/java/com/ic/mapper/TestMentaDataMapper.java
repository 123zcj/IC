package com.ic.mapper;

import com.ic.model.MentaData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TestMentaDataMapper {
    @Select("SELECT * from Test_menta_data")
    List<MentaData> getAllTestMentaData();

    @Select("SELECT * from Test_menta_data WHERE image = #{image}")
    MentaData findTestMentaDataByImage(String image);

    @Select("SELECT * from Test_menta_data WHERE age_approx = #{ageApprox}")
    List<MentaData> findTestMentaDataByAge(int age_approx);

    @Select("SELECT * from Test_menta_data WHERE sex = #{sex}")
    List<MentaData> findTestMentaDataBySex(String sex);

    @Insert("INSERT INTO Test_menta_data(image,age_approx) VALUES (#{image},#{ageApprox});")
    int insertTestMentaData_1(String image,int age_approx);

    @Insert("INSERT INTO Test_menta_data(image,age_approx,anatom_site_general,sex) VALUES (#{image},#{ageApprox},#{anatomSiteGeneral},#{sex});")
    int insertTestMentaData_2(MentaData testmentadata);
}
