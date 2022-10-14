package for_MovieWallProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "/Users/blaydeomura/documents/CS245Documents/project1/Project1File.csv";
		
		String line = "";
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			//skip row one
			br.readLine();
			
			
			//ArrayList<String> list = new ArrayList<String>();
			
			while ((line = br.readLine()) != null) { //While br has next line to read
				
				
				//List of Actors
				ArrayList<Actor> actorList = new ArrayList<Actor>();
				
				//List of Movies
				ArrayList<Movie> movieList = new ArrayList<Movie>();
				
				
				
				//Splitting right at cast column index
				String[] values = line.split("\\["); //values[1] gets the 3rd column

				//Need to convert castColumn to String
				String cast = values[1];
				
				
				
				//Split at commas to get movie column
				String[] movieColumn = line.split(",");
				//String movieName = movieColumn[1];      //got the values in movie column
				Movie movieName = new Movie(movieColumn[1].toString());
				
				movieList.add(movieName);
				
				
				
				//This creates a list of Strings that contain the title, but I want list to be Movie objects
//				String movieName = movieColumn[1];
//				ArrayList<String> movieList = new ArrayList<String>();
//				movieList.add(movieName);
				
				
				
				
				//startWordChar finds index of word "character"
				int startWordChar = cast.indexOf("character"); // returns index of character starts
				
				//startWordName finds the index of word "name"
				int startWordName = cast.indexOf("name"); //gets the "name" index
				
				
//				while (startWordChar > 0 ) { 
//					int startCharName = startWordChar + 15; //finds value of character name
//					int startActorName = startWordName + 10; //finds value of actor's real name
//					
//					//UPDATED ENDCHAR AND START CHAR
//					int endChar = cast.indexOf("\"", startCharName); //finds value of the end of character's name
//					int endActorName = cast.indexOf("\"", startActorName); //finds value of end of Actot's real name
//					
//					
//					if (endChar < cast.length() && cast.contains("character") && startCharName < cast.length()) { //if endChar is still in cast str && cast contains word char
//						String role = cast.substring(startCharName, endChar);  //role (character name) is created
//						
//						String name = cast.substring(startActorName, endActorName); //getting value of Actor's name
//						
//						actorList.add(Actor(name, role, )); 										//adding actor's name to list
//					}
//					
//					
//					startWordChar = cast.indexOf("character", endChar + 1);  //finds next value of word "character"
//					
//					
//					startWordName = cast.indexOf("name", endActorName + 1);  //finds next value of word "name"
//					
//					//break;
//					
//				}
		
				//System.out.println(list.toString() + ", ");
				System.out.println(movieList);
				
				for (int i = 0; i < movieList.size(); i++) {
					System.out.println(movieList.get(i));
				}
	

				
				break; //i know you hate this, but just to test first line of file

				
			}
		

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}}


