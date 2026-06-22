class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //

        int n = speed.length;
        Deque<Integer> s1 = new ArrayDeque<>();
        double[] timeToReachDestination = new double[n];
        Map<Integer, Double> mapping = new HashMap<>();

        for (int i=0; i<n; i++) {
            timeToReachDestination[i] = (double)(target-position[i])/speed[i];
            mapping.put(position[i],timeToReachDestination[i]);
        }

        Arrays.sort(position);

        for (int i=n-1; i>=0; i--) {
            int p1 = position[i];

            if (!s1.isEmpty()) {
                int p2 = s1.peek();
                if (mapping.get(p2) < mapping.get(p1)) {
                    s1.push(p1);
                }
            } else {
                s1.push(p1);
            }
        }

        return s1.size();

    }
}
