import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<int[]>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        int[][] result = new int[triplets.size()][];
        for (int i = 0; i < triplets.size(); i++) {
            result[i] = triplets.get(i);
        }
        return result;
    }

    static void printTriplets(int[][] triplets) {
        System.out.print("[");
        for (int i = 0; i < triplets.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print("[" + triplets[i][0] + ", " + triplets[i][1] + ", " + triplets[i][2] + "]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        printTriplets(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        printTriplets(threeSum(new int[]{0, 0, 0}));
    }
}
