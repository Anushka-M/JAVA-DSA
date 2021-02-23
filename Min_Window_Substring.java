/**
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

**/


import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
public String minWindow(String s, String t) {
        if(s.length()<t.length())
        {
            return "";
        }
		if(s.equals(t))
			return s;
		HashMap<Character,Integer> resMap = new HashMap<>();
		for(char c: t.toCharArray())
			resMap.put(c, resMap.getOrDefault(c,0)+1);
		
		String res = "";
		int minStrLen = 100000000;
		for(int i=0;i<s.length();i++)
		{
			int j = i;
			int trueLen=0;
			HashMap<Character,Integer> tempMap = new HashMap<>();
            //System.out.println("Current char is: "+ s.charAt(i));
            int start=-1;
			while(j<s.length())
			{
                //System.out.println("Curr sublen is: "+subLen);
				tempMap.put(s.charAt(j), tempMap.getOrDefault(s.charAt(j),0)+1);
                if(resMap.containsKey(s.charAt(j)) && start==-1)
                    start=j;
                //
				if(resMap.get(s.charAt(j))== tempMap.get(s.charAt(j)))
					trueLen++;
                System.out.println("start is: "+start);
				if(trueLen==resMap.size())
                    {
                    System.out.println("Here");
					if(j-start<minStrLen)
					{
                        
						res  = s.substring(start,j+1);
                        System.out.println(res);
						minStrLen  = j-start;
                        
                    }
                   if(start!=0)
                       i=start;
                    break;	
                }
                j++;
                    }
            if(start==-1 && j==s.length())
                break;

        }
		return res;
    }
}