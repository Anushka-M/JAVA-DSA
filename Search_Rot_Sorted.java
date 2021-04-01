 /** Search an item index in a sorted array that is rotated **/


 class Solution {
    
    public int searchUtil(int[] nums,int x,int s,int e)
    {
        if(s>e)
            return -1;
        
        int mid = s+(e-s)/2;
        
        if(x==nums[mid])
            return mid;
        else if(nums[s]<nums[mid])
        {
            if(x>=nums[s] && x<nums[mid])
                return searchUtil(nums,x,s,mid-1);
            return searchUtil(nums,x,mid+1,e);
        }
            
        else if(nums[mid]<nums[s])
        {
            if(x>nums[mid] && x<=nums[e])
                return searchUtil(nums,x,mid+1,e);
            return searchUtil(nums,x,s,mid-1);
        }
        else if(nums[mid]==nums[s])
        {
            if(nums[mid]!=nums[e])
                return searchUtil(nums,x,mid+1,e);
            else
            {
                int r = searchUtil(nums,x,s,mid-1);
                if(r==-1)
                    searchUtil(nums,x,mid+1,e);
                else
                    return r;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        return searchUtil(nums,target,0,nums.length-1);
    }
}