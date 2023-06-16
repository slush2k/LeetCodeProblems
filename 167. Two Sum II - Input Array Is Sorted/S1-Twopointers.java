//167. Two Sum II - Input Array Is Sorted
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) return new int[]{1,2}; //trivial condition
        //create our pointers
        int i = 1; 
        int j = 0;
        //while our largest pointer i hasnt overstepped the array length
        while (i < numbers.length){
            if (numbers[i] + numbers[j] < target){ //if the sum is too small incrememt both pointers.
                i++;
                j++;
            }
            if (numbers[i] + numbers[j] > target){ //if the sum is too big, decrement j to reduce the sum by the smallest amount.
                j--;
            }
            if (numbers[i] + numbers[j] == target){ //if the two sum eaqual target
                return new int[]{j+1,i+1}; //Found a solution at {j,i}
            }
        } 
    return new int[]{0,0}; //Did not find a solution
    }
}