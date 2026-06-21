class Solution {
    public List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return res;
    }

    public void dfs(String s, int idx, List<String> list) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
        }

        for (int i=idx; i<s.length(); i++) {
            if (isPalindrome(idx, i, s)) {
                list.add(s.substring(idx,i+1));
                dfs(s, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
