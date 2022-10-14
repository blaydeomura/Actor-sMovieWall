package for_MovieWallProject;

import java.util.ArrayList;

public class Actor {

	String name;
	String movie;
	String role;
	ArrayList<String> moviesList = new ArrayList<String>();
	
	//movie is own class
	//title + character
	
	public Actor(String theName, String theMovie, String theRole) {
		name = theName;
		movie = theMovie;
		role = theRole;
	}
	
	
}
