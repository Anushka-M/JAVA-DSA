/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

**/


import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		if(nums.length==0 || nums[0]>0 )
			return res;
		int n = nums.length();
		for(int i=0;i<n-3;i++)
		{
			int fixedNum = nums[i];
			if(i==0 || (i>0 && nums[i]!=nums[i-1])){
			int l = i+1;
			int r = n-1;
			while(l<r)
			{
				int sum = fixedNum + arr[l] + arr[r];
				if(sum<0)
					l++;
				else if(sum>0)
					r--;
				else
					res.add(new List(fixedNum,arr[l],arr[r]));
			}
		}
	}
	return res;
}
		
}
