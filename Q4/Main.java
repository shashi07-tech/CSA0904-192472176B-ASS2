import java.util.*;

public class PharmacyInventory {

    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> linkedMap = new LinkedHashMap<>();

        String[] codes = {
            "M103", "M101", "M105", "M102", "M104"
        };

        int[] stock = {
            50, 100, 30, 80, 60
        };

        // Insert medicines
        for (int i = 0; i < codes.length; i++) {

            hashMap.put(codes[i], stock[i]);
            treeMap.put(codes[i], stock[i]);
            linkedMap.put(codes[i], stock[i]);
        }

        // Lookup
        System.out.println(
            "Stock of M103: " + hashMap.get("M103")
        );

        // Code order report
        System.out.println("\nTreeMap - Code Order:");
        System.out.println(treeMap);

        // Insertion order report
        System.out.println("\nLinkedHashMap - Insertion Order:");
        System.out.println(linkedMap);

        // HashMap report
        System.out.println("\nHashMap:");
        System.out.println(hashMap);
    }
}
