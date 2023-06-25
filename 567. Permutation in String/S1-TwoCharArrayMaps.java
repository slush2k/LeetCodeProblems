//https://leetcode.com/problems/permutation-in-string/
//567. Permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false; //Check for the trival case where a larger s1 will never be a sub string of s2
        
        int[] charMapS2 = new int[26];//Holds the char counts of S2.
        int[] charMapS1 = new int[26];//Holds the char counts of S1. (What we are comparing against)
        int right = 0;
        //initalize our window
        while(right < s1.length()){ //add chars into map untill window is size of s1
            charMapS1[s1.charAt(right)-'a']++; //feed s1 into s1 char map
            charMapS2[s2.charAt(right)-'a']++; //feed s2 into s2 char map
            right++;
        }
        if (Arrays.equals(charMapS1,charMapS2)){ //check if the first try is right
            return true;
        }
        //System.out.println("Source: " + Arrays.toString(charMapS1));
        //move the window across the length of s2
        for (int left = 0; right <  s2.length(); right++, left++){
            charMapS2[s2.charAt(right)-'a']++; //add the new char to the window 
            charMapS2[s2.charAt(left)-'a']--; //remove the oldest char from the window
            
            //System.out.println(Arrays.toString(charMapS2));
            //see at every step if the new charmap is equal to our desired match (S1)
            if (Arrays.equals(charMapS1,charMapS2)){
                return true;
            }
        }
    return false; //no matches found
    }
}