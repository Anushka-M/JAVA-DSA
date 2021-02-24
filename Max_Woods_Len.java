/**
Given an array wood[] of size N, representing the length of N pieces of wood and an integer K, at least K pieces of the same length need to be cut from the given wooden pieces. The task is to find the maximum possible length of these K wooden pieces that can be obtained.
**/


import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
		
	static boolean isValid(int[] woods,int k,int n,int mid)
	{
		int count =0;
		for(int i=0;i<n;i++)
		{
			count+= woods[i]/mid;
	}
	if(count>=k)
		return true;
			return false;
			
	}
	public static int maxWoodLen(int[] woods,int k)
	{
		int n = woods.length;
			
	// store the min possible value of min possible number
		int left = 1;

		int right = Arrays.stream(woods).max().getAsInt();

		while(left<right)
		{
			int mid =  ((right-left)+left)/2;
			
		//check if it is possible to cut the wood into the mid value that we are taking

			if(isValid(woods,k,n,mid))
				left = mid+1;
			else
				right = mid-1;
		}
		return right;
	}

}
