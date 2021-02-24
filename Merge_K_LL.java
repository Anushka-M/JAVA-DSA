/**
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
**/


import java.util.*;
import java.lang.*;
import java.io.*;


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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newNode = new ListNode(-1);
        ListNode res = newNode;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for(int i=0;i<lists.length;i++)
        {
            ListNode curr = lists[i];
            while(curr!=null)
            {
                pQueue.add(curr.val);
                curr = curr.next;
            }
        }
        while(!pQueue.isEmpty())
        {
            res.next = new ListNode(pQueue.poll());
            res = res.next;
        }
        res.next = null;
        return newNode.next;
    }
}