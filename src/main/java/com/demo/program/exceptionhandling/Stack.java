package exceptionhandling;

public class Stack
{
	Contact[] constactStack = new Contact[10];
	int topPointer = 0;
		
	Contact pop() throws Exception 
	{
		if(topPointer == 0) 
		{
			throw new Exception("Underflow...");
		}
		else 
		{
		  Contact c = constactStack[topPointer-1];
		  topPointer--;
		  return c;
		}	
	}
	
	void push(Contact c) throws Exception
	{	
		if(topPointer == constactStack.length)
		{
			throw new Exception("Overflow...");
		}
		else 
		{
			constactStack[topPointer] = c;
			topPointer++;
		}	
	}	
	
	
}
