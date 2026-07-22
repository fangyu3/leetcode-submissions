class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = sum;

        for (int i=1; i<nums.length; i++) {
            if (sum + nums[i] < nums[i]) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
