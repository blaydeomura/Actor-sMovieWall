package for_MovieWallProject;

/**
 * This is a class that represents an Actor
 * @param name is the name of the actor
 * @param actorMovieList is the list of movies the actor has appeared in
 * @param role are the roles and titles of movies that the actor has appeared in
 */

import java.util.ArrayList;

/**
 * This is a class that represents the Role object which is a parameter to the Actor object
 */

public class Actor {
   
	String name;   
	ArrayList<Role> actorMoviesList = new ArrayList<Role>();         
	Role role;
	
	/**
     * Constructor for Actor object
     *
     * @param theName is the name of Actor 
     * @param theRole is the title of movie and character played
     */
	public Actor(String theName, Role theRole) {
		name = theName;								
		role = theRole;
		actorMoviesList.add(role);										
	}
	
	/**
     * Adding a title and character to MovieList
     *
     * @param theRole is the title of movie and role played by actor
     * @return null, but the title of movie and character is added to Actor's movieList
     */
	public Actor addMovie(Role theRole) { 
		role = theRole;
		actorMoviesList.add(role);
		return null;
	}
	
	/**
     * Getter of Actor name
     *
     * @param String: name is of String data type
     * @return actor's name
     */
	public String getName() {
		return name;
	}
	
	/**
     * Getter of Actor's Role object
     *
     * @param String data type
     * @return actor's movieList of toString()
     */
	public String getRole() {
		return actorMoviesList.toString();
	}
	

	/**
     * Override toString()
     *
     * @param String data type
     * @return actor's name
     */
	@Override
	public String toString() {
		return name;
	}
	
}
