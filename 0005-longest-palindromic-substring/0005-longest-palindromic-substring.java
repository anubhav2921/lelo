class Solution {

    public String longestPalindrome(String s) {

        String max = "";

        for(int i = 0; i < s.length(); i++){

            String l1 = checkPalindrome(s, i, i);

            String l2 = checkPalindrome(s, i, i + 1);

            if (l1.length() > max.length()) {
                max = l1;
            }

            if (l2.length() > max.length()) {
                max = l2;
            }
        }

        return max;
    }

    public static String checkPalindrome(String s, int left, int right){

        while(left >= 0 &&
              right < s.length() &&
              s.charAt(left) == s.charAt(right)){

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}