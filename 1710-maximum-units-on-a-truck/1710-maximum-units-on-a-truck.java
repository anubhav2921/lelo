class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int truck_capacity = truckSize;
        int max_units = 0;

        Arrays.sort(boxTypes, Comparator.comparingDouble(o -> o[1]));
        
        for(int i=boxTypes.length-1; i>=0; i--){
              if(boxTypes[i][0] <= truck_capacity){
                int curr_units = boxTypes[i][0] * boxTypes[i][1];
                max_units += curr_units;
                truck_capacity = truck_capacity - boxTypes[i][0];
              }
              else{
                int curr_units = boxTypes[i][1] * truck_capacity;
                max_units += curr_units;
                break;
              }
        }

        return max_units;
    }
}