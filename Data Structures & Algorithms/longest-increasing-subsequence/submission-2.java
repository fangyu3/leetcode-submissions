class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int res = 0;
        for (int i=0; i< nums.length; i++) {
            res = Math.max(res, dfs(i, nums, memo)+1);
        }
        return res;
    }

    public int dfs(int idx, int[] nums, int[] memo) {
        if (idx >= nums.length) {
            return 0;
        }

        if (memo[idx] != 0) {
            return memo[idx];
        }

        int res = 0;
        for (int i=idx+1; i<nums.length; i++) {
            if (nums[i] > nums[idx]) {
                res = Math.max(res, dfs(i, nums, memo)+1);
            }
        }

        memo[idx] = res;

        return res;
    }
}
