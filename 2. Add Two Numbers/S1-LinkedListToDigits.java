//https://leetcode.com/problems/add-two-numbers/
//2. Add Two Numbers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode resultHead = new ListNode();
        ListNode resultNode = resultHead;
        int carry = 0;
        int sum = 0;
        

        
        while(node1 != null || node2 != null || carry == 1){
            
            //check if end of l1
            if (node1 != null){
                sum += node1.val;
                node1 = node1.next;
            }
            //check if end of l2
            if (node2 != null){
                sum += node2.val;
                node2 = node2.next;
            }
            //Add carry if there.
            sum += carry;

            //result is the sum mod 10
            //System.out.println("Value: " + sum%10 + " Carry: " + (int)sum/10);
            resultNode.val = sum%10 ;
            carry = (int) sum/10;
            sum = 0;
            
            //System.out.println("Value: " + sum%10 + " Carry: " + (int)sum/10);
            if(node1 != null || node2 != null || carry == 1){
            //Itterate through the list
            resultNode.next = new ListNode();
            resultNode = resultNode.next;
            }
            
        }
        return resultHead;
    }
}