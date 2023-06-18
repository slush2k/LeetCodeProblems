//15. 3Sum
//https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //sort the array into numerical order
        Set<List<Integer>> results = new HashSet<List<Integer>>();
        int i_offsetprev = -1, i_offsetahead = 1; //initialize our index offsets
        //System.out.println(Arrays.toString(nums));
        //index through every item except the first and last item
        for(int i=1; i < nums.length - 1; i++){ 
            //while 'prev' and 'ahead' pointers do not run outside of array
            while( i + i_offsetahead < nums.length && i + i_offsetprev >= 0){ 
                //if the sum of a + b > - c, decrease a to decrease a + b
                if (nums[i + i_offsetahead] + nums[i + i_offsetprev] > -1*nums[i]){
                //System.out.println("Tried at: { " + nums[i + i_offsetprev] + ", " + nums[i] + ", " + nums[i + i_offsetahead] + "}");
                i_offsetprev--;

                //if the sum of a + b < - c, increase b to increase a + b
                }else if (nums[i + i_offsetahead] + nums[i + i_offsetprev] < -1*nums[i]){
                //System.out.println("Tried at: { " + nums[i + i_offsetprev] + ", " + nums[i] + ", " + nums[i + i_offsetahead] + "}");
                i_offsetahead++;
                //if the sum of a + b = - c, then a + b + c = 0 -> solution found
                }else if (nums[i + i_offsetahead] + nums[i + i_offsetprev] == -1*nums[i]){
                //System.out.println("Found at: { " + nums[i + i_offsetprev] + ", " + nums[i] + ", " + nums[i + i_offsetahead] + "}");
                results.add(List.of(nums[i + i_offsetprev],nums[i],nums[i+i_offsetahead])); //add this result to our results list
                i_offsetahead++; //force the check for the next solution at this index i
                }
            }
            //reset our offesets
            i_offsetprev = -1;
            i_offsetahead = 1;
        }
    return List.copyOf(results);
    }
}