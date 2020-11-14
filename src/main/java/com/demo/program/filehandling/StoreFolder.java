package com.demo.program.filehandling;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoreFolder 
{	
	public static void main(String[] args) {
		
		storeFiles("src");	
		
	}
	
	public static void storeFiles(String path) {

        File file = new File(path);
		
		//Check whether it is a file or a directory.
		System.out.println(file.isDirectory()? "is a directory" : "not a directory");
		
		System.out.println("All the files present int the directory (folder) : \n");
		Map<String, String> mapStore = new HashMap<String, String>();
		
		for(File folderContent : file.listFiles())
		{
			System.out.println(folderContent+"\n");
			mapStore.put(folderContent.getName(), folderContent.getPath());
			if(folderContent.isDirectory()) 
			{
				for(File subFiles : folderContent.listFiles())
				{
					mapStore.put(subFiles.getName(), subFiles.getPath());
				}
			}
		}
		
		Set<String> keys = mapStore.keySet();
		 
		for(String s : keys)
	     	System.out.println(s);
	}
}