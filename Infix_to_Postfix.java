/** Infix to Postfix expression **/



// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().infixToPostfix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends



class Solution{
    
    public static int getPrec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
       
        case '*':
        case '/':
            return 2;
       
        case '^':
            return 3;
        }
        return -1;
    }
	public static String infixToPostfix(String exp) {
		// Your code here
		
		String res = "";
		Stack<Character> stack = new Stack<>();
		
		for(char c:exp.toCharArray())
		{
		    if(Character.isAlphabetic(c) || Character.isDigit(c))
		        res+=String.valueOf(c);
		    else
		    {
		        if(stack.isEmpty() || c=='(')
		            stack.push(c);
		        else if(!stack.isEmpty() && c==')')
		        {
		            while(!stack.isEmpty() && stack.peek()!='(')
		                res+=String.valueOf(stack.pop());
		            stack.pop();
		        }
		        else // an operator is encountered
                {
                    int prec= getPrec(c);
                    while (!stack.isEmpty() && prec!=-1 && prec <= getPrec(stack.peek()))
                    {
                        
                        res += String.valueOf(stack.pop());
                    }
                    stack.push(c);
                }   
		    }
		}
		
		while(!stack.isEmpty())
		{
		    if(stack.peek() == '(')
                return "Invalid Expression";
            res += String.valueOf(stack.pop());
		}
		return res;
	} 
}