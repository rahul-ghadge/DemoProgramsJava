package filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MyFile 
{
	public static void main(String[] args)
	{	
		File myFile = new File("files/File1.txt");
		System.out.println(myFile);
		System.out.println("is file? = "+myFile.isFile());
		System.out.println("Can execute? : "+myFile.canExecute());
		System.out.println("Can read? - "+myFile.canRead());
		System.out.println("Can write? - "+myFile.canWrite());
		System.out.println("File exists? - "+myFile.exists());
		System.out.println("Absolute Path of file - "+myFile.getAbsolutePath());
		System.out.println("Free space = "+myFile.getFreeSpace());
		System.out.println("Name of file : "+myFile.getName());
		System.out.println("Parent of file (Parent directory): "+myFile.getParent());
		System.out.println("Path : (Project path)"+myFile.getPath());
		System.out.println("Total Space : "+myFile.getTotalSpace()+" Bytes");
		System.out.println("Usable Space = "+myFile.getUsableSpace()+" Bytes");
		System.out.println("Length of file in Bytes : "+myFile.length());
		System.out.println("Last Modified Date and time : "+new Date(myFile.lastModified()));
		System.out.println(myFile.isAbsolute() ? "is absolute" : "not a absolute");
		System.out.println(myFile.isDirectory() ? "is a directory" : "not a directory");
		System.out.println(myFile.compareTo(new File("files/File2.txt")));
		try 
		{
			System.out.println("Canonical Path : "+myFile.getCanonicalPath());
			System.out.println("Create new File ? = "+myFile.createNewFile());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
