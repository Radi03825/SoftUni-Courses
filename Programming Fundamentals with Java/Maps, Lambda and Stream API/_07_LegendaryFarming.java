import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new HashMap<>();

        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);

        boolean isObtained = false;

        while (!isObtained){
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i+=2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                if(material.equals("fragments") || material.equals("shards") || material.equals("motes")){
                    if(keyMaterials.containsKey(material)){
                        quantity += keyMaterials.get(material);
                    }
                    if(quantity >= 250){
                        isObtained = true;
                        if(material.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }else if(material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else if(material.equals("motes")){
                            System.out.println("Dragonwrath obtained!");
                        }
                        keyMaterials.put(material, quantity - 250);
                        break;
                    }
                    keyMaterials.put(material, quantity);
                }else {
                    if(junkMaterials.containsKey(material)){
                        quantity += junkMaterials.get(material);
                    }
                    junkMaterials.put(material, quantity);
                }
            }
        }
        keyMaterials.entrySet().stream()
                .sorted((f, s) -> f.getKey().compareTo(s.getKey()))
                .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junkMaterials.entrySet().stream()
                .sorted((f, s) -> f.getKey().compareTo(s.getKey()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
