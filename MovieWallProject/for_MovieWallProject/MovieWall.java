package for_MovieWallProject;

/**
 * Actor's Movie Wall
 * @BlaydeOmura
 */

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
	
	
	public void readFile(String fileName) {
		
		String path = fileName;
		
		String line = "";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { 
			
			br.readLine();  //skips row one because we dont need it
			
			ArrayList<Movie> movieList = new ArrayList<Movie>();
			
			while ((line = br.readLine()) != null) { //While br has next line to read
					 
				
				String[] values = line.split("}]\","); //Splitting right at cast column index
				if (values.length == 1) continue;

				String cast = values[0];    //Need to convert castColumn to String
				
				String[] movieColumn = line.split(",");   //Split at commas to get movie column
			
				Movie movieName = new Movie(movieColumn[1]);			
				movieList.add(movieName);
			
				int startWordChar = cast.indexOf("character"); //startWordChar finds index of word "character"
				
				int startWordName = cast.indexOf("name"); //startWordName finds the index of word "name"
				

				while (startWordChar > 0 ) { 
					int startCharName = startWordChar + 15; //finds value of character name
					int startActorName = startWordName + 10; //finds value of actor's real name
					
					
					int endChar = cast.indexOf("\"", startCharName); //finds value of the end of character's name
					int endActorName = cast.indexOf("\"", startActorName); //finds value of end of Actot's real name
					
					
					if (endChar < cast.length() && cast.contains("character") && startCharName < cast.length()) { //if endChar is still in cast str && cast contains word char
						String character = cast.substring(startCharName, endChar);  //role (character name) is created
						
						String name = cast.substring(startActorName, endActorName); //getting value of Actor's name
						
						Role role = new Role(movieName, character);	
						
						getActor(name, role);
					}
					
					startWordChar = cast.indexOf("character", endChar + 1);  //finds next value of word "character"
					
					startWordName = cast.indexOf("name", endActorName + 1);  //finds next value of word "name"
				}
				
			}

			
			QuickSort quickSort = new QuickSort(); //call quickSort to sort data
			quickSort.sort(actorList);
			
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Actor> getActorList () {
		return actorList;
	}
	
	
	/**
     * Function that creates a new Actor object only if Actor object does not already exist
     *
     * @param Actor data type
     * @param name is name of actor
     * @param role is the title of a movie and character actor plays
     * @return index of already existing Actor
     * @return OR creating of new Actor
     */
	public Actor getActor(String name, Role role) {
		for (int i = 0; i < actorList.size(); i++) {
			if (actorList.get(i).getName().equalsIgnoreCase(name)) {
				actorList.get(i).addMovie(role);
				return actorList.get(i);
			}
		}
		Actor addActor = new Actor(name, role);
		actorList.add(addActor);
		return addActor;
	}
	
	/**
     * Function to Binary Search for an Actor
     *
     * @param actorList is the list of Actor objects
     * @param target is the name user is trying to find
     * @param String data type
     * @return the target's movieList
     * @return or asks if user meant another Actor 
     */
    public static String binSearch(ArrayList<Actor> actorList, String target) {
    	int low = 0;
    	int high = actorList.size()-1;
    	int mid;
    	
    	while (low <= high) {
    		mid = low + (high - low) / 2;
    		
    		if (actorList.get(mid).getName().compareToIgnoreCase(target) < 0)
    			low = mid + 1;
    		else if (actorList.get(mid).getName().compareToIgnoreCase(target) > 0)
    			high = mid - 1;
    		else
    			return actorList.get(mid).getRole().replace("[", "").replace("]", "").replace(",", "");
    	}
    	System.out.print("No such Actor. Did you mean " + "'" + actorList.get(high + 1).getName() + "'" + "(Y/N)");
    	Scanner scan = new Scanner(System.in);
    	String userAnswer = scan.next();
    	if (userAnswer.equals("Y"))
    		return actorList.get(high + 1).getRole().replace("[", "").replace("]", "").replace(",", "");
    	else 
    		return "You chose 'N'. Try again!";
    }
		
	
	public static void main(String[] args) {
		MovieWall mw = new MovieWall();
		mw.readFile(args[0]);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Movie Wall!");
		String actorSearch = " ";
		
		while (!actorSearch.equals("EXIT") || !actorSearch.equals("exit")) {
			System.out.print("Enter the name of your desired actor (or type 'EXIT' to quit): ");
			actorSearch = scan.nextLine();
			if (actorSearch.equals("EXIT") || actorSearch.equals("exit")) {
				System.out.println("Thanks for using MovieWall!");
				break;    //I'm sorry
			} else {
				System.out.println("Actor: " + actorSearch);
				System.out.println(binSearch(actorList, actorSearch));
			}
		}		
		scan.close();
			
}}



