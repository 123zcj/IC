package com.ic.controller;


import com.ic.model.PredictionResponse;
import com.ic.service.FlaskModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class PredictionController {

    private final FlaskModelService flaskModelService;

    @Autowired
    public PredictionController(FlaskModelService flaskModelService) {
        this.flaskModelService = flaskModelService;
    }

    @PostMapping("/predict")
    public PredictionResponse predict(@RequestParam("file") MultipartFile file) {
        // 1. 验证文件
        if (file.isEmpty()) {
            throw new IllegalArgumentException("请上传图片文件");
        }

        // 2. 检查文件类型
        String contentType = file.getContentType();
        if (contentType == null ||
                (!contentType.equals("image/jpeg"))) {
            throw new IllegalArgumentException("仅支持JPEG图片");
        }

        // 3. 调用Flask服务
        return flaskModelService.predictSkinCondition(file);
    }
}