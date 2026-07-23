class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int n:nums) {
            set.add(n);
        }

        for (int n:set) {
            int length = 0;
            if (!set.contains(n-1)) {
                while (set.contains(n)) {
                    length++;
                    n++;
                }
                res = Math.max(res, length);
            }
        }

        return res;
        
    }
}
