package com.ic.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Train_ground_truth")
public class TrainGroundTruth {
    @Id
    @TableId(type = IdType.AUTO)
    int id;

    String image;
    int type;

    /***
     1为MEL,
     2为NV,
     3为BCC,
     4为AK,
     5为BKL,
     6为DF,
     7为VASC,
     8为SCC,
     9为UNK
     * ***/

    public TrainGroundTruth(String image, int type) {
        this.image = image;
        this.type = type;
    }
    public TrainGroundTruth() {
    }

    public TrainGroundTruth(String image) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // CSV行转换构造函数
    public TrainGroundTruth(String[] csvRow) {
        if (csvRow.length < 10) {
            throw new IllegalArgumentException("Invalid CSV row");
        }
        this.type = -1;
        this.image = csvRow[0].trim();
        for (int i = 1; i < 9; i++) {
            if (csvRow[i].trim().equals("1.0") ) {
                this.type = i;
                break;
            }
        }
        if(csvRow[9].trim().equals("1.0"))
            this.type = 9;

        if(this.type<0)
            throw new IllegalArgumentException("Invalid Type Value "+this.type);
    }


}
