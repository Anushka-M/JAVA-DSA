/** Input: [[1,5],[4,6],[8,10],[8,18],[2,3]]

 Output: [[1,6],[8,10],[15,18]]

track of range -> Greedy - Job Scheduling



output : [1,10],[15,18]
x1 = left->1,right->5 < x2.left x2.right>
x2 = left->4, right->6 


1,2,3,5,15
5,8,6,6,18
output: [1,8][15,18]
maxSofar -> MIN_INTEGER -> 5
minSofar -> MAX_INTEGER -> 1
 **/


class Solution
{
	public ArrayList<ArrayList<Intger>> nonOverlapRange(ArrayList<ArrayList<Integer>> arr)
	{

		//corner case
		if(arr.size()==1 || arr.size()==0)
			return arr;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Collection.sort(arr.get(0), comparator(int a,int b)
		{
				if(a>b)
					return a;
				retun b;
		});
		int minSofar = Integer.MAX_VALUE;
		int maxSofar = Integer.MIN_VALUE;
		int i=0;
		while(i<arr.size())
		{
			// max - 5 , min-1;
			if(i==0)
			{
				minSofar = arr.get(i).get(0);
				maxSofar = arr.get(i).get(1);
			}
			i++;
			// update maxSofar and also check that we don't reach a point where maxSofar< 0th index element- break the loop
			while(maxSofar>arr.get(i).get(0) && i<arr.size())
			{
				if(arr.get(i).get(1)>maxSofar)
					maxSofar = arr.get(i).get(1);
				
				i++;
			}
			// Add the min and max so far in the result array and update 
			res.add(new ArrayList(minSofar,maxSofar));
			minSofar = arr.get(i).get(0);
			maxSofar = arr.get(i).get(1);
					

		}
		return res;

	}

}


/*
1,2,3,5,15, 16, 23
5,3,6,10,18, 24, 25

i =4
max = 10
min = 1

get(0) = 15
get(1) = 18

*/