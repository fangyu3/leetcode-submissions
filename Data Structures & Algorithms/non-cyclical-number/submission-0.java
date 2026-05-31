class Solution {
    public boolean isHappy(int n) {
        // while number is not 1
        // add sum to set
        // iteratively get digit and add to sum
        // check if num is seen -> return false;
        // num = sum

        int num = n;
        int sum = 0;
        Set<Integer> seen = new HashSet<>();

        while (num != 1) {
            seen.add(num);
            while (num != 0) {
                int digit = num%10;
                num /= 10;
                sum += digit*digit;
            }

            num = sum;

            if (seen.contains(num)) {
                return false;
            }

            sum = 0;
        }

        return true;
    }
}
