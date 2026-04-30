class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (n-1 != edges.length) {
            return false;
        }

        if (n == 1 && edges.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> mapping = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (int[] e:edges) {
            int n1 = e[0];
            int n2 = e[1];
            mapping.computeIfAbsent(n1, x-> new ArrayList<>()).add(n2);
            mapping.computeIfAbsent(n2, x-> new ArrayList<>()).add(n1);
        }

        dfs(seen, edges[0][0], mapping);

        return seen.size() == n;
    }

    public void dfs(Set<Integer> seen, int node, Map<Integer, List<Integer>> mapping) {
        if (seen.contains(node)) {
            return;
        }

        seen.add(node);

        for (int neighbor: mapping.getOrDefault(node, new ArrayList<>())) {
            dfs(seen, neighbor, mapping);
        }
    }
}
