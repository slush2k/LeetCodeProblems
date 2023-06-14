//128. Longest Consecutive Sequence
//https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0; //null condition
        Arrays.sort(nums); //Sort order the list so that sequential numbers are imediately identifiable.
        //initalize maximum variables to keep track of begining of sequence and maximum sequence size.
        int max = 1; 
        int start = 0;
        //itterate through the array
        for(int i = 1; i < nums.length ; i++){
            //if the number isnt increasing by 1 or equal to the number previous then the max subsequence size must have been reached.
            if ((nums[i] != nums[i-1] + 1) && (nums[i] != nums[i-1])){
            
                max = Math.max(i - start, max); //check to see if this sequence if the largest
                start = i; //update start to reflect a new sequence.
            }else if(nums[i] == nums[i-1]){
                start++;
                //if duplicate value increase start index to compensate
            }
        }
        max = Math.max((nums.length) - start , max); //see if the ending sequence is the largest.
    return max;
    }
}