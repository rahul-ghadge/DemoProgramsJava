package com.demo.program.filehandling;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SearchUtility {

	public static void main(String[] args) 
	{		
		if(searchFile("src", "StoreFolder.java"))
		   System.out.println("File found..");
		else
			System.out.println("File not present...");	
	}
	
	
	public static boolean searchFile(String path, String filename) {
		
		File file = new File(path);
		Map<String, String> mapStore = new HashMap<String, String>();
		
		for(File folderContent : file.listFiles())
		{
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
		
		for(String s : keys) {
			if( s.equalsIgnoreCase(filename)) {
				return true;
			}
			
		}
		
		return false;
	}
	
}
