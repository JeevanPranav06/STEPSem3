public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int lowest = prices[0];
        int bestProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - lowest;
            if (profit > bestProfit) {
                bestProfit = profit;
            }
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
