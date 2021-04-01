/** Remove K duplicate adj characters from a string eg: k=2 str=abcccdccde output=abce **/

class Solution {
    class CharCount
    {
        char c;
        int count;
        CharCount(char c,int count)
        {
            this.c = c;
            this.count=count;
        }
        
        protected void inCount()
        {
            count++;
        }
    }
    public String removeDuplicates(String s, int k) {
        if(s.length()<k)
            return s;
        Stack<CharCount> stack = new Stack<>();
        String res = "";
        for(char c: s.toCharArray())
        {
            
            if(stack.isEmpty() || stack.peek().c!=c)
            {
                stack.push(new CharCount(c,1));
                
            }
            
            else
            {
                stack.peek().inCount();
                System.out.println(stack.peek().count+" "+stack.peek().c);
                if(stack.peek().count==k)
                    stack.pop();
            }
                        
        }
        while(!stack.isEmpty())
        {
            int i = stack.peek().count;
            while(i-->0)
                res=String.valueOf(stack.peek().c)+res;
            stack.pop();
            
            
        }
        return res;
    }
}