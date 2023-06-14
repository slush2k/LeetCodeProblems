//This is from the leet code problem 217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        //Create a new Hash Set to store each integer value
        HashSet <Integer> numsHash = new HashSet<Integer>();
        //add each value of nums array into the hash set
        for(int i = 0; i < nums.length; i++){
            if(numsHash.contains(nums[i])){ //if the hash set already has this value then return true. the array has a duplicate value.
                return true;
            }
            numsHash.add(nums[i]); //else add the value to the hash set.
        }
    return false; //no duplicates found in the array
    }
}