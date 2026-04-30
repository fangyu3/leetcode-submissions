class Solution {
    public int climbStairs(int n) {
        Map<Integer,Integer> memo = new HashMap<>();
        return dfs(0, n, memo);
    }

    public int dfs(int steps, int n, Map<Integer,Integer> memo) {
        if (steps == n) {
            return 1;
        }

        if (steps > n) {
            return 0;
        }

        if (memo.containsKey(steps)) {
            return memo.get(steps);
        }

        int res = dfs(steps+1, n, memo) + dfs(steps+2,n, memo);

        memo.put(steps,res);
        return res;
    }
}
