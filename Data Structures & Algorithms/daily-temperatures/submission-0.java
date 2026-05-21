class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // brute force O(n^2)

        // put the idx into stack
        // pop the top element if the new incoming temp is higher for both stacks
        // calculate the difference in idx

        Deque<Integer> s = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int top = s.pop();
                res[top] = i-top;
            }

            s.push(i);
        }

        return res;
    }
}
