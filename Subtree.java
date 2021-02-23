/**
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
**/


import java.util.*;
import java.lang.*;
import java.io.*;


public class TreeNode
{
	TreeNode right, left;
	int val;
	TreeNode(){}
	TreeNode(int data)
	{
		this.val = data;
		right = null;
		left = null;
}
} 

class Solution {
		public boolean isSame(TreeNode s, TreeNode t)
		{
			if(s==null && t==null)
					return true;
				if(s==null || t==null)
					return false;
				
				return isSame(s.val==t.val && isSame(s.left,t.left) && isSame(s.right,t.right));
		}

		public boolean isSubTree(TreeNode s, TreeNode t)
		{
			//pre-order traversal of the Main Tree
			
			Queue<TreeNode> bfsQ = new LinkedList<>();
			bfsQ.add(s);
			while(!bfsQ.isEmpty())
			{
				TreeNode temp = bfsQ.poll();
				if(temp.val==t.val)
					if(isSame(temp,t))
						return true;
				if(temp.left!=null)
					bfsQ.add(temp.left);
				if(temp.right!=null)
					bfsQ.add(temp.right);
		}
		return false;
		}  
		}
