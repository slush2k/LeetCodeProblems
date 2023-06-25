//424. Longest Repeating Character Replacement
//https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] charFrequency = new int[26]; //Tracks frequency of chars contained in substring
        int l = 0; //left pointer
        int longest = 0;
        for(int r = 0 ; r < s.length(); r++){
            charFrequency[s.charAt(r) - 'A']++; //increase the number of that character seen
            longest = longest >= charFrequency[s.charAt(r)- 'A'] ? longest : charFrequency[s.charAt(r)- 'A']; //get longest character window
            if ((r+1-l) - longest > k){ //if the difference between wordsize and maximum count of a character is largerthan k then
                //"dequeue" the first character of our substring in given window
                charFrequency[s.charAt(l) - 'A']--;  //remove 1 count of that character
                l++; //increase our left pointer by 1
            }
            //System.out.println(s.substring(l,r+1));
        }
    return s.length()-l; //return window size as it will follow the largest word size
    }
}