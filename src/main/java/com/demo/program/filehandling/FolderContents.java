package filehandling;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FolderContents {

	public static void main(String[] args) {
		
		displayFolderContents("src");
		
	}
	
	public static void displayFolderContents(String path) {
		
		File file = new File(path);
		
		//Check whether it is a file or a directory.
		System.out.println(file.isDirectory()? "is a directory" : "not a directory");
		
		System.out.println("All the files present int the directory (folder) : ");
		
		for(File folderContent : file.listFiles())
		{	
			System.out.println(folderContent+"\n");	
			if(folderContent.isDirectory()) {
				for(File subFiles : folderContent.listFiles()) {
					System.out.println(subFiles.getName());
				}
			}
		}	
	} 	
	
}
