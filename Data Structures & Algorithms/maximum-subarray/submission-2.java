class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = sum;

        for (int i=1; i<nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
