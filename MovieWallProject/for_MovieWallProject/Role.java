package for_MovieWallProject;

/**
 * This is a class that represents the Role object which is a parameter to the Actor object
 */

public class Role {

	Movie movie;
	String character;
	
	/**
     * Constructor for Role object
     *
     * @param theMovie is title of movie
     * @param theCharacter is the character actor plays
     */
	public Role (Movie theMovie, String theCharacter) {
		movie = theMovie;
		character = theCharacter;
	}
	
	/**
     * Getter for movie
     *
     * @param Movie object data type
     * @return movie name
     */
	public Movie getMovie() {
		return movie;
	}

	/**
     * Getter for character
     *
     * @param String data type
     * @return character played
     */
	public String getCharacter() {
		return character;
	}
	
	/**
     * Override toString()
     *
     * @param String data type
     * @return movie's title and character that actor plays
     */
	@Override
	public String toString() {
		return "* Movie: " + movie + " as " + character + "\n";
	}
	
	
	
	
}
