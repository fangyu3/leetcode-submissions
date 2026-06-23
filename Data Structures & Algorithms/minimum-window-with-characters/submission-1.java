class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mapping = new HashMap<>();
        Map<Character,Integer> mappingT = new HashMap<>();

        for (char c:t.toCharArray()) {
            mappingT.put(c, mappingT.getOrDefault(c,0)+1);
            mapping.put(c, 0);
        }

        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        String res = "";

        while (r<s.length()) {
            
            char c = s.charAt(r);
            if (mappingT.containsKey(c)) {
                mapping.put(c, mapping.getOrDefault(c,0)+1);
            }

            while (isWindowValid(t, mapping, mappingT)) {
                if (r-l+1<min) {
                    min = r-l+1;
                    res = s.substring(l,r+1);
                }
                c = s.charAt(l);
                if (mappingT.containsKey(c)) {
                    mapping.put(c, mapping.get(c)-1);
                }
                l++;
            }

            r++;
        }
        return res;

    }

    public boolean isWindowValid(String t, Map<Character, Integer> mapping, Map<Character, Integer> mappingT) {
        for (char c:t.toCharArray()) {
            if (mapping.getOrDefault(c,0) < mappingT.getOrDefault(c,0)) {
                return false;
            }
        }

        return true;
    }

}
