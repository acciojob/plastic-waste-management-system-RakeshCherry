import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlasticWaste {

    // A private map to store plastic types and their corresponding weights
    private Map<String, Double> plasticWasteMap = new HashMap<>();

    // Method to add a new type of plastic waste
    public void addPlasticType(String plasticType, double weight) {
        plasticWasteMap.put(plasticType, weight);
        System.out.println("Stored data for " + plasticType + ".");
    }

    // Method to update the weight of an existing type of plastic waste
    public void updatePlasticWeight(String plasticType, double weight) {
        if (plasticWasteMap.containsKey(plasticType)) {
            plasticWasteMap.put(plasticType, weight);
            System.out.println("Updated weight for " + plasticType + " to " + weight + " kg.");
        } else {
            System.out.println(plasticType + " does not exist. Please add it first.");
        }
    }

    // Method to get the total weight of all plastic waste
    public double getTotalWeight() {
        return plasticWasteMap.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    // Method to get the weight of a specific type of plastic
    public double getPlasticWeight(String plasticType) {
        return plasticWasteMap.getOrDefault(plasticType, 0.0);
    }

    // Method to get the type of plastic with the highest weight
    public String getHeaviestPlasticType() {
        return plasticWasteMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No plastic waste recorded.");
    }

    public static void main(String[] args) {
        PlasticWaste plasticWaste = new PlasticWaste();

        // Sample Input
        plasticWaste.addPlasticType("PET", 50.5);
        plasticWaste.addPlasticType("HDPE", 35.2);
        plasticWaste.addPlasticType("PVC", 75.8);

        // Sample Output
        System.out.println("Total weight of plastic waste: " + plasticWaste.getTotalWeight() + " kg");
        System.out.println("Weight of HDPE: " + plasticWaste.getPlasticWeight("HDPE") + " kg");
        System.out.println("Heaviest plastic type: " + plasticWaste.getHeaviestPlasticType());
    }
}
