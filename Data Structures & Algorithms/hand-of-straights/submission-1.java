class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // store number:count in mapping
        // for each group, start with the smallest number and devrement count
        // see if the next +1 number exists
        // loop until all groups are satisfied

        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> mapping = new TreeMap<>();
        for (int n:hand) {
            mapping.put(n, mapping.getOrDefault(n,0)+1);
        }

        int numGroups = hand.length/groupSize;

        for (int i=0; i<numGroups; i++) {
            int num = mapping.firstKey();
            int count = mapping.get(num)-1;
            if (count == 0) {
                mapping.remove(num);
            } else {
                mapping.put(num, count);
            }
            for (int j=1; j<groupSize; j++) {
                num = num+1;
                if (!mapping.containsKey(num)) {
                    return false;
                }

                count = mapping.get(num)-1;

                if (count == 0) {
                    mapping.remove(num);
                } else {
                    mapping.put(num, count);
                }
            }
        }

        return true;
    }
    
}
