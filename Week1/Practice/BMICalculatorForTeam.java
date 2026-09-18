public class BMICalculatorForTeam {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25) {
            return "Normal";
        }
        if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d | %.2f | %.2f | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.82, 1.68, 1.73, 1.90};
        double[] weights = {70, 90, 75, 55, 80, 48, 95, 62, 68, 110};
        printWellnessReport(heights, weights);
    }
}
