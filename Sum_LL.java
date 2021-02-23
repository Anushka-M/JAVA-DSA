/**

Q1: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

**/


import java.util.*;
import java.lang.*;
import java.io.*;


public class ListNode
{
	ListNode next;
	int val;
	
	//constructor
	ListNode(int val)
	{
		this.data = val;
		next = null;
}
}

class Solution
{	
	static ListNode getSumLl(ListNode l1,ListNode l2)
	{
		//corner cases
		if(l1==null || l2==null)
			return l1==null? l2 : l1;
		int carry=0;
		ListNode head = new ListNode(-1);
		ListNode node = head;

		while(l1!=null || l2!=null)
		{
			int x = (l1!=null)? l1.val : 0;
			int y = (l2!=null)? l2.val: 0;
			int sum = x+y+carry;
			carry  = sum/10;
			node.next = new ListNode(sum%10);
			node = node.next;
			l1 = l1!=null ? l1: null;
			l2 = l2!=null? l2: null; 

			}
					if (carry>0)
					{
						node.next = new ListNode(1);
						node = node.next;
			}
			return head.next;
	}	
}

