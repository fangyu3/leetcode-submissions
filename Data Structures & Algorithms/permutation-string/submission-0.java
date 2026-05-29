class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // mapping to get s1 character freq
        // sliding window in s2 to see if char freq matches

        if (s1.length() > s2.length()) {
            return false;
        }

        int l1 = s1.length();
        int l2 = s2.length();

        int[] freqArr1 = new int[26];
        int[] freqArr2 = new int[26];

        for (char c:s1.toCharArray()) {
            freqArr1[c-'a']++;
        }

        int l=0;
        int r=0;

        while(r<l2) {
            char c = s2.charAt(r);
            freqArr2[c-'a']++;

            if (r-l +1> l1) {
                c = s2.charAt(l);
                freqArr2[c-'a']--;
                l++;
            }

            if (Arrays.equals(freqArr1, freqArr2)) {
                return true;
            }

            r++;
        }

        return false;
    }
}
