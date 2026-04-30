class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int n:nums) {
            sum += n;
            set.add(n);
        }

        int doubleSum = 0;
        for (int n:set) {
            doubleSum += n*2;
        }

        return doubleSum-sum;
    }
}
