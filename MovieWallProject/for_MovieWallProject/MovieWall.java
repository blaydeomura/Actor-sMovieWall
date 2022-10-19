package for_MovieWallProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MovieWall {

	//List of Actors
	static ArrayList<Actor> actorList = new ArrayList<Actor>();
	
	
	public void readFile() {
		
		
		String path = "/Users/blaydeomura/documents/CS245Documents/project1/Project1File.csv";
		
		String line = "";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { 
//			BufferedReader br = new BufferedReader(new FileReader(path));
			
			//skip row one
			br.readLine();
			
			
			//List of Movies
			ArrayList<Movie> movieList = new ArrayList<Movie>();
			
			
//			while ((line = br.readLine()) != null) { //While br has next line to read
			int count = 0;
			while ((line = br.readLine()) != null && count < 101) { //erase later
				
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
				

//				if (movieName.equals("Mulan")) {
//					System.out.println("Found");
//				}
				

				
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
						
						
						
						//add this back
						//Actor addActor = new Actor(name, role);
						
						
						getActor(name, role);
						
						
						//else create new actor
						
						//actorList.add(addActor);
					
						//addActor.addMovie(role);
						//System.out.print(addActor); //print actors
						
						
						
					}
					
					
					startWordChar = cast.indexOf("character", endChar + 1);  //finds next value of word "character"
					
					
					startWordName = cast.indexOf("name", endActorName + 1);  //finds next value of word "name"
					
					
				}
				
				//break; //i know you hate this, but just to test first line of file
			}
//			System.out.println(movieList);
			
//			System.out.println(actorList);
			
			Collections.sort(actorList, new SortComparator());
			
//			System.out.println(actorList);
			
			
			
//			System.out.println(actorList.get(10).getRole());
			


			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Actor> getActorList () {
		return actorList;
	}
	
	
	
//removing duplicates
	public Actor getActor(String name, Role role) {
		for (int i = 0; i < actorList.size(); i++) {
			if (actorList.get(i).getName().equals(name)) {
				actorList.get(i).addMovie(role);
				return actorList.get(i);
			}
		}
		Actor addActor = new Actor(name, role);
		actorList.add(addActor);
		return addActor;
	}

	
//trouble comparing 
	public static Actor linSearch(String actorSearch, ArrayList<Actor> actorList) {
		for (int j = 0; j < getActorList().size(); j++) {
			if (actorSearch.equals(getActorList().get(j).getName())) 
				//System.out.println(getActorList().get(i));
				return getActorList().get(j);
		}
		//return a name similar to that of the name requested
		//just returning random value for now
		return getActorList().get(20);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieWall mw = new MovieWall();
		mw.readFile();
		
		//Name that I want to find DELETE Later
		System.out.println(getActorList().get(31).getName());
		
		
		//UserInterface ui = new UserInterface();
		System.out.println("Welcome to the Movie Wall!");
		System.out.println("Enter the name of your desired actor or type 'EXIT' to quit.");
		
		//delete testing
		//System.out.println(getActorList().size());
		
		Scanner scan = new Scanner(System.in);
		String actorSearch = scan.next();
//		
//		
//		for (int i = 0; i < getActorList().size(); i++) {
//			if (findActor.equals(getActorList().get(i).getName())) 
//				//System.out.println(getActorList().get(i));
//				System.out.println("Nice!");
//		}
		
		//System.out.println(getActorList().get(3).getName());
		System.out.println(linSearch(actorSearch, getActorList()));
		

		

		
		
		
		
		
		
		
		
		//Trying to test linear search and print movie wall
		//
//		for (int i = 0; i < actorList.size(); i++) {
//			if (findActor.equals(actorList.get(i))) {
//				System.out.println(actorList.get(i));
//			}
//			else
//				//return someone similar?
//		}
//		
//		
//		System.out.println(findActor);

		
		
		
}}



