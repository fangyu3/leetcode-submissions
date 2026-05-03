class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return dfs(0, nums, memo);
    }

    public boolean dfs(int idx, int[] nums, Boolean[] memo) {
        if (idx >= nums.length-1) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        int steps = nums[idx];

        for (int i=1; i<=steps; i++) {
            if(dfs(idx+i, nums, memo)) {
                return true;
            }
        }

        memo[idx] = false;

        return false;
    }
}
