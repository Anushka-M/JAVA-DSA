/* Implement a Binary Min Heap*/


/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    static class Heap
    {
        private int capacity =0;
        private int size =0;
        
        int[] items = new int[capacity];
        private int getLeftChildIndex(int parentIndex){return 2*parentIndex+1;}
        private int getRightChildIndex(int parentIndex){return 2*parentIndex+2;}
        private int getParentIndex(int childIndex){return (childIndex-1)/2;}
        
        private boolean hasRightChild(int index){return getRightChildIndex(index)<size;}
        private boolean hasLeftChild(int index){return getLeftChildIndex(index)<size;}
        private boolean hasParent(int index){return getParentIndex(index)>=0;}
        
        private int getLeftChild(int parentIndex){return items[getLeftChildIndex(index)];}
        private int getRightChild(int parentIndex){return items[getRightChildIndex(index)];}
        private int getParent(int childIndex){return items[getParent(index)];}
        
        public void swap(int a,int b)
        {
            int temp = items[a];
            items[a]  = items[b];
            items[b] = temp;
        }
        
        //basic implementation of ArrayList
        private void incCapacity()
        {
            if(size==capacity)
            {
                items = Arrays.copyOf(items,capacity*2);
                capacity=*2;
            }
        }
        public int peek()
        {
            if(size==0)
                return -1;
            items[0];
        }
        
        public int poll()
        {
            if(size==0)
                return -1;
            int item = items[0];
            items[0] = items[size-1];
            size--;
            heapifyDown(items);
            items[0];
        }
        
        public void add(int el)
        {
            incCapacity();
            items[size] = el;
            size++;
            
        }
        
        public void heapifyUp()
        {
            index=size-1;
            heapifyUp(hasParent[index] && getParent(index)>items[index])
            {
                swap(getParent(index),index);
                index = getParent(index);
            }
            
        }
        
        public void heapifyDown()
        {
            index =0;
            while(hasLeftChild(index))
            {
                int smallChild = getLeftChildIndex(index);
                
                if(hasRightChild(index) && getRightChild(index)<getLeftChild(index))
                {
                    smallChild = getRightChildIndex(index);
                }
                if(items[index]>items[smallChild])
                {
                    break;
                }
                else
                {
                    swap(index,smallChild);
                }
                index = smallChild;
                
                
            }
        }
        
    }
    
    
	public static void main (String[] args) {
		System.out.println("GfG!");
		int[] arr = {3,1,7,5,7,9,3};
		buildBinaryHeap(arr);
	}
}