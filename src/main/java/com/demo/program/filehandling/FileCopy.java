package com.demo.program.filehandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		
		File file1 = new File("files/File1.txt");
		File file2 = new File("files/File2.txt");
		copyFile(file1, file2);
	}
	
	
	static void copyFile(File fileName1, File fileName2) 
	{		
		
		byte[] buffer = new byte[2000];
		try 
		{
			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName1));
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName2));
			
			int bytes;

			while((bytes = inputStream.read(buffer)) != -1) {
				outputStream.write(bytes);
			}
			
			System.out.println("Data copied from File1.txt to File2.txt");
			inputStream.close();
			outputStream.close();
			
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found Exception...");
		}
		catch(IOException e) 
		{
			System.out.println("IOException...");
		}
		
	}
	
}
