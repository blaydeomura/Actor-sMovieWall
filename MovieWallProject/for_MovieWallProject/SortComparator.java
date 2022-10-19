package for_MovieWallProject;

import java.util.Comparator;

public class SortComparator implements Comparator<Actor> {

	@Override
	public int compare(Actor o1, Actor o2) {
		// TODO Auto-generated method stub
		
		return o1.getName().compareToIgnoreCase(o2.getName()); 
		
		//if equal, 0
		//if o1 < o2, it will return value less than 0
		//if o2 > o1, it will return value greater than 0
	}

}
