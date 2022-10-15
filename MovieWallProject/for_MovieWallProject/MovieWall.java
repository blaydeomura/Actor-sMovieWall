package for_MovieWallProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieWall {

	//List of Actors
	ArrayList<Actor> actorList = new ArrayList<Actor>();
	
	
	public void readFile() {
		
		
		String path = "/Users/blaydeomura/documents/CS245Documents/project1/Project1File.csv";
		
		String line = "";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { 
//			BufferedReader br = new BufferedReader(new FileReader(path));
			
			//skip row one
			br.readLine();
			
//			//List of Actors
//			ArrayList<Actor> actorList = new ArrayList<Actor>();
			
			//List of Movies
			ArrayList<Movie> movieList = new ArrayList<Movie>();
			
			
//			while ((line = br.readLine()) != null) { //While br has next line to read
			int count = 0;
			while ((line = br.readLine()) != null && count < 101) {
				
				count++;
				
				 
				//Splitting right at cast column index
				String[] values = line.split("\\["); //values[1] gets the 3rd column

				//Need to convert castColumn to String
				String cast = values[1];
				
				
				//Split at commas to get movie column
				String[] movieColumn = line.split(",");
				//String movieName = movieColumn[1];      //got the values in movie column
				Movie movieName = new Movie(movieColumn[1]);			
				movieList.add(movieName);
			
				
				//startWordChar finds index of word "character"
				int startWordChar = cast.indexOf("character"); // returns index of character starts
				
				//startWordName finds the index of word "name"
				int startWordName = cast.indexOf("name"); //gets the "name" index
				

				if (movieName.equals("Mulan")) {
					System.out.println("Found");
				}
				

				
				while (startWordChar > 0 ) { 
					int startCharName = startWordChar + 15; //finds value of character name
					int startActorName = startWordName + 10; //finds value of actor's real name
					
					//UPDATED ENDCHAR AND START CHAR
					int endChar = cast.indexOf("\"", startCharName); //finds value of the end of character's name
					int endActorName = cast.indexOf("\"", startActorName); //finds value of end of Actot's real name
					
					
					if (endChar < cast.length() && cast.contains("character") && startCharName < cast.length()) { //if endChar is still in cast str && cast contains word char
						String character = cast.substring(startCharName, endChar);  //role (character name) is created
						
						String name = cast.substring(startActorName, endActorName); //getting value of Actor's name
						
						Role role = new Role(movieName, character);
						
					
						Actor addActor = getActor(name);
						addActor.addMovie(role);
						//System.out.println(addActor); //print actors
					}
					
					
					startWordChar = cast.indexOf("character", endChar + 1);  //finds next value of word "character"
					
					
					startWordName = cast.indexOf("name", endActorName + 1);  //finds next value of word "name"
					
				}
				
				//break; //i know you hate this, but just to test first line of file
			}
//			System.out.println(movieList);
//			System.out.println(actorList);
			

			

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	//Things to do
	//Get input from user and print out wall
	//gives me right actor, if not exist, creates new

	//Start with binary search on the actorList
	//If bin search fails, then I need to insert new 
	//Insertion different because start with something outside of list
	public Actor getActor(String name) {
		for (int i =0; i < actorList.size(); i++) {
			if (actorList.get(i).equals(name)) 
				return actorList.get(i);
		}
		//if not found
		Actor actor = new Actor(name);
		actorList.add(actor);
		return actor;
	}
	
	
//FAILED IMPLEMENTATION OF INSERTION SORT	
//trying to implement insertion sort
//	public Actor getActor(String name) {
//		for (int i =0; i < actorList.size(); i++) {
//			if (actorList.get(i).equals(name)) { 
//				return actorList.get(i);
//			}
//		}
//		actorList.add(null);
//		Actor actor = new Actor(name);
//		int y;   
//		int z;
//		Actor key;  //key
//		for (z = 1; z < actorList.size(); z++) {  //iterate through size starting at names[1]
//			key = actor;  //changing
//			y = z - 1;            //y is set to beginning of arrayList
//			while (y >= 0 && actorList.get(y).compareToIgnoreCase(key) > 0) {				  //while (i <= 0) keep looping  going
//				actorList.set(y+1, key);
//				y--;
//				}
//				actorList.set(y+1, key);  //names[1] = names[0] --> jennifer law, then sam
//			}
//		return actor;
//		}

	int actorListLength = actorList.size();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieWall mw = new MovieWall();
		mw.readFile();
		
		//UserInterface ui = new UserInterface();
		System.out.println("Welcome to the Movie Wall!");
		System.out.println("Enter the name of your desired actor or type 'EXIT' to quit.");
		
		Scanner scan = new Scanner(System.in);
		String findActor = scan.next();
		
		
		
		//Trying to test linear search and print movie wall
		//
		for (int i = 0; i < actorList.size(); i++) {
			if (findActor.equals(actorList.get(i))) {
				System.out.println(actorList.get(i));
			}
			else
				//return someone similar?
		}
		
		
		//System.out.println(findActor);

		
		
		
}}



