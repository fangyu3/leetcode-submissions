class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][2];
        return dfs(prices, 0, 0, memo);
    }

    public int dfs(int[] prices, int idx, int holding, Integer[][] memo) {
        if (idx >= prices.length) {
            return 0;
        }

        if (memo[idx][holding] != null) {
            return memo[idx][holding];
        }

        int res = Integer.MIN_VALUE;
        if (holding == 1) {
            res = Math.max(prices[idx] + dfs(prices,idx+2, 0, memo),dfs(prices,idx+1, 1, memo));
        }

        if (holding == 0) {
            res = Math.max(-prices[idx] + dfs(prices,idx+1, 1, memo), dfs(prices,idx+1, 0, memo));
        }

        memo[idx][holding] = res;

        return res;
    }
}
