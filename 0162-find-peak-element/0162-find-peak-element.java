
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[mid+1]){
                // We are on the ascending side.
                // A peak must exist to the right of mid.
                low = mid + 1;
            }else{
                // We are on the descending side.
                // A peak exists at mid or somewhere to the left.
                high = mid;
            }
        }
        return low;
    }
}