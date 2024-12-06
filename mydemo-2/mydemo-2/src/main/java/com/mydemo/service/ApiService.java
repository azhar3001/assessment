package com.mydemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydemo.model.data.ApiStateDto;
import com.mydemo.model.data.BranchDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    private final RestTemplate restTemplate;

    @Value("${api.malaysia.states.url}")
    private String malaysiaStatesUrl;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BranchDto getBranch(String code) {
        try {
            logger.info("Calling Malaysia states API");
            String response = restTemplate.getForObject(malaysiaStatesUrl + code, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            ApiStateDto apiStateDto = objectMapper.readValue(response, ApiStateDto.class);
            return new BranchDto(apiStateDto.getName(), apiStateDto.getCapital(), apiStateDto.getPicName());
        } catch (Exception e) {
            logger.error("Error calling Malaysia states API: {}", e.getMessage());
            return null;
        }
    }
}