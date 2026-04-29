class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0) {
            return 0;
        }

        Set<Character> seen = new HashSet<>();

        int r = 0;
        int l = 0;
        int res = r-l+1;

        while (r<s.length()) {
            char curr = s.charAt(r);
            while (seen.contains(curr)) {
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(curr);
            res = Math.max(res, r-l+1);
            r++;
        }

        return res;
    }
}
