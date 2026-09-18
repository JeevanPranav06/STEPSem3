import java.util.HashMap;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCounts = new HashMap<Integer, Integer>();
        prefixCounts.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            Integer needed = prefixCounts.get(currentSum - k);
            if (needed != null) {
                count += needed;
            }
            Integer existing = prefixCounts.get(currentSum);
            if (existing == null) {
                prefixCounts.put(currentSum, 1);
            } else {
                prefixCounts.put(currentSum, existing + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
