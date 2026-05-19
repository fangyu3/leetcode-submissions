class Solution {
    public boolean isAnagram(String s, String t) {
        // Traverse 1st string, increase the freq for each char
        // Traverse 2nd string, decrease the freq for each char
        // Traverse freq mapping and see if all letter freqs are 0

        if (s.length() != t.length()) {
            return false;
        }

        int[] freqMapping = new int[26];

        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            freqMapping[c1-'a']++;
            freqMapping[c2-'a']--;
        }


        for (int n:freqMapping) {
            if (n!=0) {
                return false;
            }
        }

        return true;
    }
}
