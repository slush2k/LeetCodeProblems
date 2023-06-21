//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/description/
//slow
class Solution {
    public int trap(int[] height) {
        int[] displacement = new int[height.length];
        int water = 0;
        Stack<Integer> availableHeight = new Stack<Integer>();
        for(int i = 1; i< height.length ; i++){
        displacement[i] = height[i] - height[i-1];

        }
        //Array is now in displacement form
        //System.out.println(Arrays.toString(displacement) + availableHeight + " Water: " + water);
        for(int i = displacement.length -1, end = displacement.length - 1; i >= 0; i--){
            if (displacement[i] > 0){
                //if number is postive this is a filling candidate
                availableHeight.push(i);
            }
            //if number is negative and there are fillers available
            while(displacement[i] < 0 && !availableHeight.empty()){
                //get the next closest filler
                int aH = availableHeight.pop();
                //see if the puddle is under or over filled
                int netSum = displacement[i] + displacement[aH];
                //record the water filled
                water += (aH-i)*(Math.min(-displacement[i],displacement[aH]));
                //water += (aH-i)*(displacement[i]);
                //the filler has height to spare
                if (netSum > 0){
                    displacement[aH] += displacement[i];
                    displacement[i] = 0;
                    availableHeight.push(aH);
                //the filler cant fill the water all the way
                }else{ //(netSum <= 0)
                     displacement[i] = netSum;
                     displacement[aH] = 0;
                }
            //System.out.println(Arrays.toString(displacement) + availableHeight + " Water: " + water);
            }
        }
        //System.out.println(Arrays.toString(displacement));
        return water;
    }
}