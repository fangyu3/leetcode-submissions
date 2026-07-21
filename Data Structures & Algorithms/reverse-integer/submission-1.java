class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        String maxInteger = String.valueOf(Integer.MAX_VALUE);
        String minInteger = String.valueOf(Integer.MIN_VALUE);

        if ((x<0 && s.length() > minInteger.length()) || (x>0 && s.length() > maxInteger.length())) {
            return 0;
        }

        int l = x<0 ? 1:0;
        int r = s.length()-1;
        char[] charArr = s.toCharArray();

        while (l<r) {
            char temp = charArr[l];
            charArr[l] = charArr[r];
            charArr[r] = temp;
            l++;
            r--;
        }

        s = new String(charArr);
        System.out.println("new String " + s);

        if (x>0 && s.length() == maxInteger.length() && s.compareTo(maxInteger) > 0) {
            return 0;
        }

        if (x<0 && s.length() == minInteger.length() && s.compareTo(minInteger) > 0) {
                    System.out.println("here");
            System.out.println("minInteger: " + minInteger);
            return 0;
        }

        return Integer.parseInt(s);


    }

    
}
