
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    long[] sum, sq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int r = 0; r < n; r++) {
            int prev = last.getOrDefault(nums[r], -1);

            update(1, 0, n - 1, prev + 1, r);

            ans = (ans + sq[1]) % MOD;
            last.put(nums[r], r);
        }

        return (int) ans;
    }

    void apply(int node, int l, int r, long val) {
        long len = r - l + 1L;

        sq[node] = (sq[node] + 2 * val * sum[node]
                    + len * val % MOD * val) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) return;

        int mid = (l + r) >>> 1;
        long v = lazy[node];

        apply(node << 1, l, mid, v);
        apply(node << 1 | 1, mid + 1, r, v);

        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }

        push(node, l, r);
        int mid = (l + r) >>> 1;

        if (ql <= mid)
            update(node << 1, l, mid, ql, qr);

        if (qr > mid)
            update(node << 1 | 1, mid + 1, r, ql, qr);

        sum[node] = (sum[node << 1] + sum[node << 1 | 1]) % MOD;
        sq[node] = (sq[node << 1] + sq[node << 1 | 1]) % MOD;
    }
}
