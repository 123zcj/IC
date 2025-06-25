package com.ic.service;


import com.ic.model.PredictionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FlaskModelService {
    @Value("${flask.service.url}")
    private String flaskServiceUrl;

    private final RestTemplate restTemplate;

    public FlaskModelService()
    {
        restTemplate = new RestTemplate();
    }

    public PredictionResponse predictSkinCondition(MultipartFile file) {
        try {
            // 1. 准备请求头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // 2. 准备文件部分
            ByteArrayResource fileResource = new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            };

            // 3. 创建多部分请求体
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", fileResource);

            // 4. 创建请求实体
            HttpEntity<MultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(body, headers);

            // 5. 发送请求到Flask服务
            String predictUrl = flaskServiceUrl + "/predict_image";
            ResponseEntity<PredictionResponse> response = restTemplate.exchange(
                    predictUrl,
                    HttpMethod.POST,
                    requestEntity,
                    PredictionResponse.class
            );

            // 6. 返回响应体
            return response.getBody();

        } catch (Exception e) {
            throw new RuntimeException("调用模型服务失败: " + e.getMessage(), e);
        }
    }
}
