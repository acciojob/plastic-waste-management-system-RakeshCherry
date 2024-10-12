package com.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PlasticWaste {

    private Map<String, Double> plasticWasteMap;

    public PlasticWaste() {
        this.plasticWasteMap = new HashMap<>();
    }

    public void addPlasticType(String type, double weight) {
        plasticWasteMap.put(type, weight);
    }

    public void updatePlasticWeight(String type, double newWeight) {
        if (plasticWasteMap.containsKey(type)) {
            plasticWasteMap.put(type, newWeight);
        }
    }

    public double getTotalWeight() {
        return plasticWasteMap.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getWeightByType(String type) {
        return plasticWasteMap.getOrDefault(type, 0.0);
    }

    public String getTypeWithHighestWeight() {
        return plasticWasteMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}

