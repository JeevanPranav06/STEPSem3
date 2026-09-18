public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }
        String status;
        if (totalA == totalB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }
        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestItem = 1;
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestItem = i + 1;
            }
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestItem = i + 1;
            }
        }
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + highest
                + " (" + highestSection + ", Item " + highestItem + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
