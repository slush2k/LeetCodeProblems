//125. Valid Palindrome
//https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        //convert string to Alphanumeric lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        //see if the ith index index equals the (n-i)th index eg. begining equals the end.
        for(int i = 0; i < s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
    return true;
    }
}