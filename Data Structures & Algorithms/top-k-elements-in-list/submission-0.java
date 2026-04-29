class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> freq = new ArrayList<>();
        Map<Integer, Integer> mapping = new HashMap<>();

        for (int n:nums) {
            mapping.put(n, mapping.getOrDefault(n,0)+1);
        }

        for (int i=0; i<nums.length+1; i++) {
            freq.add(i, new ArrayList<>());
        }

        for (Map.Entry<Integer,Integer> e: mapping.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();

            freq.get(count).add(num);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i=freq.size()-1; i>=0; i--) {
            List<Integer> l = freq.get(i);
            for (int num:l) {
                res[idx] = num;
                idx++;
                k--;
                if (k==0) {
                    break;
                }
            }

            if (k==0) {
                break;
            }
        }

        return res;

    }
}