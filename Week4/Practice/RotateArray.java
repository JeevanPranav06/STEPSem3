public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        k = k % nums.length;
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotated[i];
        }
        return nums;
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
        printArray(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        printArray(rotateArray(new int[]{1, 2}, 3));
    }
}
