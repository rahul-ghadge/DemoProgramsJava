package com.demo.program.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

	public static void main(String[] args) {
		
		int result = countWords("files/File1.txt");
		System.out.println("Total number of words in the file are = "+result);
		
	}
	
	
	@SuppressWarnings("resource")
	static public int countWords(String filePath) {
		
		int count_words=0;
		FileReader f;
		String lines="";
		try 
		{
			f = new FileReader(filePath);
			BufferedReader buffer = new BufferedReader(f);
			while((lines = buffer.readLine()) != null) {
				String[] split_lines = lines.split(" ");
				count_words += split_lines.length; 
			}
		
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return count_words;
		
		
			
	} 
	
}
