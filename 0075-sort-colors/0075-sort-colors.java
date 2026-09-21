class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int ele : nums) {
            count[ele]++;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while(count[j] == 0) j++;
            nums[i] = j;
            count[j]--;
        }
    }
}