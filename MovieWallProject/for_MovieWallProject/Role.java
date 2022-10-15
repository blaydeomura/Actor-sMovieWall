package for_MovieWallProject;

public class Role {

	Movie movie;
	String character;
	
	public Role (Movie theMovie, String theCharacter) {
		movie = theMovie;
		character = theCharacter;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public String getCharacter() {
		return character;
	}
	
	@Override
	public String toString() {
		return "Role [movie=" + movie + ", character=" + character + "]";
	}
	
	
	
	
}
