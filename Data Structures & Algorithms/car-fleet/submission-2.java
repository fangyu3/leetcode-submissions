class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Calcuate time left to reach desinitation from each cars current position
        /* Push to stack one by one and compare the time, if time is larger it means the car 
         never reach the car infront of it, otherwise it will reach and join the fleet*/


         int n = speed.length;
         // stores the cars initial position and it's remaining time to target destination
         double[][] cars = new double[n][2];

         for (int i=0; i<n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target-position[i])/speed[i];
         }

         Arrays.sort(cars, (a,b)->Double.compare(b[0], a[0]));
         Deque<Double> s = new ArrayDeque<>();

         for (int i=0; i<n; i++) {
            double[] car = cars[i];
            if (s.isEmpty() || car[1] > s.peek()) {
                s.push(car[1]);
            }
         }

         return s.size();
    }
}
