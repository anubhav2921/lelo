class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<int[]> available =
            new PriorityQueue<>((a,b) ->
                a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);

        PriorityQueue<int[]> busy =
            new PriorityQueue<>((a,b) ->
                a[0] != b[0] ? a[0]-b[0] :
                a[1] != b[1] ? a[1]-b[1] : a[2]-b[2]);

        // Step 1: Add all servers
        for(int i = 0; i < servers.length; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[tasks.length];
        long time = 0;

        // Step 2: Process every task
        for(int i = 0; i < tasks.length; i++) {

            time = Math.max(time, i);

            // Step 3: Make free servers available
            while(!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] s = busy.poll();
                available.offer(new int[]{s[1], s[2]});
            }

            // Step 4: If no server is free, wait
            if(available.isEmpty()) {

                time = busy.peek()[0];

                while(!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] s = busy.poll();
                    available.offer(new int[]{s[1], s[2]});
                }
            }

            // Step 5: Select best server
            int[] s = available.poll();

            ans[i] = s[1];

            // Step 6: Make server busy
            busy.offer(new int[]{
                (int)(time + tasks[i]), s[0], s[1]
            });
        }

        return ans;
    }
}