package com.demo.program.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Movie{
	
	String movieName;
	Language language;
	Date date;
	enum Language{
		ENGLISH, HINDI, MARATHI;
	}
	
	public Movie(String movieName, Language language, Date date) {
		this.movieName = movieName;
		this.language = language;
		this.date = date;
	}
}

public class MovieData 
{

	public static void main(String[] args) {		
		List<Movie> list = readMovieData("files/movies.txt");
		
		for (Movie m : list) {
			System.out.println(m.movieName+"\t"+m.language+"\t"+m.date);
			System.out.println("-------------------------------------------------------------");
		}
	}
	
	
	@SuppressWarnings("resource")
	public static List<Movie> readMovieData(String filename){
	
		FileReader f;
		String lines="";
		Movie.Language language=null;		
		List<Movie> movieList = new ArrayList<>();
		String[] split_lines = new String[4];
		
		try 
		{	
			f = new FileReader(filename);
			BufferedReader buffer = new BufferedReader(f);
			while((lines = buffer.readLine()) != null) 
			{
				split_lines = lines.split(",");		
			

				for(Movie.Language l : Movie.Language.values()) {
					
					if(l.name().equalsIgnoreCase(split_lines[2])) {
					language = l;
					break;
				}
			  }
		        Date date = new SimpleDateFormat("dd/mm/yy").parse(split_lines[3]);		
				movieList.add(new Movie(split_lines[1], language, date));
			}
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (ParseException e)
		{
			System.out.println(e.getMessage());
		}
		
		return movieList;
	}
	
}
