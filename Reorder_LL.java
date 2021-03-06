/**
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

Leetcode:127
Solution: https://leetcode.com/problems/reorder-list/discuss/1095802/Inituitive-JAVA-solution-with-slow-and-fast-pointers
**/


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
public ListNode reverse(ListNode head)
{
	ListNode curr = head;
	ListNode next = null;
	ListNode prev = null;
	while(curr!=null)
	{
		next= curr.next;
		curr.next = prev;
		prev=curr;
		curr=next;
}
head=prev;
return head;
}
public void reorderList(ListNode head) {
    if(head == null || head.next == null || head.next.next == null) return;
        //we can use the two pointer solution for this
ListNode slow = head;
ListNode fast = head;
while(fast!=null && fast.next!=null)
{
	slow = slow.next;
	fast=fast.next.next;
}
ListNode head2;
if(fast==null)
{
	head2 = reverse(slow.next);
}
else
{
	head2 = reverse(slow);
}

slow.next=null;

while(head2!=null &&head!=null )
{
        ListNode tempNode = head.next;
            head.next = head2;
            head2 = head2.next;
            head.next.next =  tempNode;
            head = tempNode;
    
	
}



    }
}