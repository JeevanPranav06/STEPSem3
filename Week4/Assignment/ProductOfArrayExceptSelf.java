public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return answer;
    }

    static void printArray(int[] values) {
        System.out.print("[");
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(values[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        printArray(productExceptSelf(new int[]{1, 2, 3, 4}));
        printArray(productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }
}
