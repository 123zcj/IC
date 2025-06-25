package com.ic.utils;


import com.ic.model.MentaData;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CsvUtils {

    public static List<MentaData> parseCsvFile(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<MentaData> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(MentaData.class);

            CsvToBean<MentaData> csvToBean = new CsvToBeanBuilder<MentaData>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception ex) {
            throw new RuntimeException("解析CSV文件失败: " + ex.getMessage(), ex);
        }
    }
}