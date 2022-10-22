package for_MovieWallProject;

/**
 * This is a class that represents the Movie object
 */


public class Movie {

	String title;
	
	/**
     * Constructor for Movie object
     *
     * @param String data type
     * @param theTitle is the title of Movie
     * @return actor's movieList of toString()
     */
	public Movie(String theTitle) {
		title = theTitle;
	}

	/**
     * Override toString()
     *
     * @param String data type
     * @return title of movie
     */
	@Override
	public String toString() {
		return title;
	}
	
	
	
	
}
