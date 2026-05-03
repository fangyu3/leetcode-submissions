class Solution {
    public boolean canJump(int[] nums) {
        return dfs(0, nums);
    }

    public boolean dfs(int idx, int[] nums) {
        if (idx >= nums.length-1) {
            return true;
        }

        int steps = nums[idx];

        for (int i=1; i<=steps; i++) {
            if(dfs(idx+i, nums)) {
                return true;
            }
        }

        return false;
    }
}
