//11. Container With Most Water
//https://leetcode.com/problems/container-with-most-water/description/
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1; //init pointers to the begining and end of array.
        int max = 0;
        while (i < j){
            //using terinary opperators to increase speed further (at cost of readability).
            //first see what the minimum "water level is" eg. 7 & 8 "wall" so max water height is 7.
            //second see if the distance, x (or j-i), times the water height, (7 in our example) is the maximum area seen thus far. 
            //third record the max.
            max = (j-i)*(height[i] < height[j] ? height[i]: height[j]) > max ? (j-i)*(height[i] < height[j] ? height[i]: height[j]): max;
            //max = Math.max((j-i)*Math.min(height[i],height[j]),max); //Simplified expression
            
            //fourth find the next largest candidate:
            //increment/decrement the smallest number out of the two indexes.
            if (height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
    return max; //return the maximum
    }
}