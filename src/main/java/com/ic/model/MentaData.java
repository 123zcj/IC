package com.ic.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Test_menta_data")
public class MentaData {
    @Id
    @TableId(type = IdType.AUTO)
    int id;
    String image;
    int ageApprox;

    public MentaData(String image, int ageApprox) {
        this.image = image;
        this.ageApprox = ageApprox;
    }

    String anatomSiteGeneral;
    String sex;

    public MentaData() {
    }

    public MentaData(int id, String image, int ageApprox, String anatomSiteGeneral, String sex) {
        this.id = id;
        this.image = image;
        this.ageApprox = ageApprox;
        this.anatomSiteGeneral = anatomSiteGeneral;
        this.sex = sex;
    }

    public MentaData(String image, int ageApprox, String anatomSiteGeneral, String sex) {
        this.image = image;
        this.ageApprox = ageApprox;
        this.anatomSiteGeneral = anatomSiteGeneral;
        this.sex = sex;
    }

    public MentaData(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAgeApprox() {
        return ageApprox;
    }

    public void setAgeApprox(int age_approx) {
        this.ageApprox = age_approx;
    }

    public String getAnatomSiteGeneral() {
        return anatomSiteGeneral;
    }

    public void setAnatomSiteGeneral(String anatom_site_general) {
        this.anatomSiteGeneral = anatom_site_general;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    // CSV行转换构造函数
    public MentaData(String[] csvRow) {
        if (csvRow.length < 4) {
            throw new IllegalArgumentException("Invalid CSV row");
        }
        this.image = csvRow[0].trim();
        if(csvRow[1].trim()=="")
            this.ageApprox = 0;
        else
        this.ageApprox = Integer.parseInt(csvRow[1].trim());

        this.anatomSiteGeneral = csvRow[2].trim();
        this.sex = csvRow[3].trim();
    }
}
