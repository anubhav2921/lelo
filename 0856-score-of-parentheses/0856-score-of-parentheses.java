class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        int score = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push(score);
                score = 0;
            } 
            else {
                int prev = st.pop();

                if (s.charAt(i - 1) == '(') {
                    score = prev + 1;
                } 
                else {
                    score = prev + 2 * score;
                }
            }
        }

        return score;
    }
}