class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer,Integer> mapping = new HashMap<>();
        int res = 1;
        int length = 1;

        for (int n:nums) {
            mapping.put(n,null);
        }

        for (int n:nums) {
            if (mapping.get(n) != null) {
                continue;
            }

            length = 1;
            mapping.put(n, length);
            while (mapping.containsKey(n+1)) {
                n = n+1;
                length++;
                mapping.put(n, length);
                res = Math.max(res, length);
            }
            
        }

        return res;
    }
}
