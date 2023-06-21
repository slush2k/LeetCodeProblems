//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class Solution {
    public int lengthOfLongestSubstring(String s) {
    HashMap <Character, Integer> charMap = new HashMap<>();
    int max = 0;
    for (int i = 0, j = 0; i < s.length(); i++){
        //see if the character has already appeared in the hashmap
        if (charMap.containsKey(s.charAt(i))){
            j = Math.max(j, charMap.get(s.charAt(i))+1);
        }
        //put char -> index into map
        charMap.put(s.charAt(i), i);
        max = Math.max(max, i- j + 1);
        //max(max, currentwindowlength)
    }
    //System.out.println(charMap);
    return max; 
    }
}