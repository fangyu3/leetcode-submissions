class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        int[] indegrees = new int[numCourses];
        List<Integer> res = new ArrayList<>();

        for (int[] p:prerequisites) {
            int c1 = p[0];
            int c2 = p[1];

            // c2 is c1's prerequisite

            mapping.computeIfAbsent(c2, x->new ArrayList<>()).add(c1);
            indegrees[c1]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i=0; i<indegrees.length; i++) {
            if (indegrees[i]==0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int p = q.poll();

            res.add(p);

            for (int c:mapping.getOrDefault(p, new ArrayList<>())) {
                indegrees[c]--;
                if (indegrees[c] == 0) {
                    q.offer(c);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[0];
        }

        int[] resArr = new int[numCourses];

        for (int i=0; i<res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }
}
