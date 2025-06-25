package com.ic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class PredictionResponse {
    private int class_index;
    private double confidence;
    @JsonProperty("all_predictions")
    private List<List<Double>> allPredictions;


    public PredictionResponse() {
    }

    public int getClass_index() {
        return class_index;
    }

    public void setClass_index(int class_index) {
        this.class_index = class_index;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public List<List<Double>> getAllPredictions() {
        return allPredictions;
    }

    public void setAllPredictions(List<List<Double>> allPredictions) {
        this.allPredictions = allPredictions;
    }
}