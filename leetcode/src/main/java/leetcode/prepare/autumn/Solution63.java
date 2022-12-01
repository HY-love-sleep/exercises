package leetcode.prepare.autumn;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/31 15:08
 * @description：股票最大利润
 */
public class Solution63 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            res = Math.max(res, (price - minPrice));
        }
        return res;
    }
}
