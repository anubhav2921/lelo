class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        for (int i = 0; i<n; i++){
            int Lsum = 0;
            for(int j = 0; j<i; j++)
            {
                Lsum += nums[j];
            }
            int Rsum=0;
            for(int j= i+1; j<n; j++ ){
                Rsum += nums[j];

            }
            if(Lsum== Rsum){
                return i;
            }

        }
        return -1;
    }
}