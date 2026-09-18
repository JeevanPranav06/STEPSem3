public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            double average = rowAverage(runsPerOver[i]);
            String label;
            if (average >= threshold) {
                label = "Power Surge";
            } else {
                label = "Normal";
            }
            result.append("Match ").append(i).append(": ").append(label);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
