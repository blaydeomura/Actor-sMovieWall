package for_MovieWallProject;

import java.util.ArrayList;

public class Actor {
   
	String name;   //name of actor
	ArrayList<Role> actorMoviesList = new ArrayList<Role>();           //list of movies actor appears in
	Role role;
	
	public Actor(String theName) {
		name = theName;
	}
	
	
	//contrstuctor for new actor
	public Actor(String theName, Role theRole) {
		name = theName;								
		role = theRole;
		actorMoviesList.add(role);										//add movie name and character to actorMovieList
	}
	
	
	
	//When actor exists in ActorList
	public void addMovie(Role theRole) {
		role = theRole;
		actorMoviesList.add(role);
	}
	
	
	public String getName() {
		return name;
	}
	

	
	//generate toString() here
	@Override
	public String toString() {
		return name;
	}
//	public String toString() {
//		return "Actor: " + name + "\n" 
//				+ "Movie: " + role.getMovie() + "as" + role.getCharacter();
//		
//	}


	public int compareToIgnoreCase(Actor actor) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
