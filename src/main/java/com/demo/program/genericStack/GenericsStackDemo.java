package com.demo.program.genericStack;

public class GenericsStackDemo<T> {

	int topPointer;
	final int maxSize=100;
	
	
	@SuppressWarnings("unchecked")
	T stack[] = (T[]) new Object[maxSize];
	

    T pop() throws Exception 
	{
		if(topPointer == 0) 
		{
			throw new Exception("Underflow...");
		}
		else 
		{
		  T c = stack[topPointer-1];
		  topPointer--;
		  return c;
		}	
	}
	
	void push(T c) throws Exception
	{	
		if(topPointer ==stack.length)
		{
			throw new Exception("Overflow...");
		}
		else 
		{
			stack[topPointer] = c;
			topPointer++;
		}	
	}	
}
