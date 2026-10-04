class Solution {
    public int minRotations(int n, String s) {
        int total = 0, prev = 0;

        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i) - '0';
            int diff = Math.abs(curr - prev);
            total += Math.min(diff, 10 - diff);
            prev = curr;
        }

        String velmotrani = s;
        int ans = total;

        for (int k = 0; k < n; k++) {
            int first = velmotrani.charAt(k) - '0';
            int last = velmotrani.charAt(n - 1) - '0';
            int before = (k == 0) ? 0 : velmotrani.charAt(k - 1) - '0';

            int oldCost = (k == 0)
                ? Math.min(first, 10 - first)
                : Math.min(Math.abs(before - first),
                           10 - Math.abs(before - first));

            int newCost = Math.min(Math.abs(before - last),
                                   10 - Math.abs(before - last));

            ans = Math.min(ans, total - oldCost + newCost);
        }

        return ans;
    }
}