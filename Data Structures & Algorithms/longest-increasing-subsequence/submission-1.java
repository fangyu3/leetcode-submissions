class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        return dfs(0, nums, -1001, memo);
    }

    public int dfs(int idx, int[] nums, int prev, int[] memo) {
        if (idx >= nums.length) {
            return 0;
        }

        if (memo[idx] != 0) {
            return memo[idx];
        }

        int res = 0;
        for (int i=idx; i<nums.length; i++) {
            if (nums[i] > prev) {
                res = Math.max(res, dfs(i+1, nums, nums[i], memo)+1);
            }
        }

        memo[idx] = res;

        return res;
    }
}
