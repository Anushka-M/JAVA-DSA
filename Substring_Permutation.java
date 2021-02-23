/**
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
**/


import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	 public List<Integer> findSubstring(String s, String[] words)
	{
		List<Integer> res = new ArrayList<>();
		int subWordLen = words[0].length();
		int totalLen = subWordLen * words.length;
		int n = words.length;
		if(totalLen>s.length())
			return res;
		HashMap<String,Integer> fixMap = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			fixMap.put(words[i],fixMap.getOrDefault(words[i],0)+1);
		}

		for(int i=0;i+totalLength<=s.length();i++)
		{
			int j =i;
			HashMap<String,Integer> tempMap = new HashMap<>();
			int wordsFound =0;
			while(j+subWordLen<=s.length())
			{
				String currWord = s.substring(j,j+subWordLen);
				if(fixMap.get(currWord)==0)
					break;
				wordsFound++;
				tempMap.put(currWord,tempMap.getOrDefault(words[i],0)+1);
				if(tempMap.get(currWord)>fixMap.get(currWord))
					break;
				if(wordsFound==n)
					res.add(i);
				j+=subWordLen;
			}
		}
		return res;
	}
}
