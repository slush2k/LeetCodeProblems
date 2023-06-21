//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/description/
//Fast
class Solution {
    public int trap(int[] height) {
        int waterSum = 0;
        int waterLevelLeft = 0;
        int waterLevelRight = 0;
        int left = 0, right = height.length-1;
        while (left <= right){
            if (waterLevelLeft < waterLevelRight){
                waterLevelLeft = (height[left] > waterLevelLeft ? height[left] : waterLevelLeft); //get max waterlevel - Left
                waterSum+= waterLevelLeft - height[left]; //waterLevel - height is water contained in collum. -> add it to total
                left++; //increment left
            }else{
                waterLevelRight = (height[right] > waterLevelRight ? height[right] : waterLevelRight); //get max waterlevel - Right
                waterSum += waterLevelRight - height[right]; //waterLevel - height is water contained in collum. -> add it to total
                right--; //increment right
            }
        }
        return waterSum;
    }
}