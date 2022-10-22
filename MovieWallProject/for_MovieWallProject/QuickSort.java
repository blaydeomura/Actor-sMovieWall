package for_MovieWallProject;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
 
    /**
     * sorting function that implements quicksort*
     *
     * @param actorList unsorted ArrayList
     * @param <T>      Generic data type 
     */
    public static <T extends Comparable<T>> void sort(ArrayList<Actor> actorList) {
        quickSort(actorList, 0, actorList.size() - 1);
    }

    /**
     * Recursively quick sorting the array by randomPartitioning*
     *
     * @param actorList unsorted ArrayList
     * @param left     left boundary
     * @param right    right boundary
     * @param <T>      data type T
     */
    public static <T extends Comparable<T>> void quickSort(ArrayList<Actor> actorList, int left, int right) {
        // pivot assignment should call the randomPartition helper function
        // figure out the new left and right boundary based on the pivot  
    	
    	if (left < right) {
    		int pi = randomPartition(actorList, left, right);
    		
    		quickSort(actorList, left, pi-1); //new right is pivot - 1
    		quickSort(actorList, pi, right); //new left is pivot
    		
    	}
    	
    }

    /**
     * random partitioning with Math.random() function to generate a random index *
     * *
     *
     * @param actorList unsorted ArrayList
     * @param left     left pointer
     * @param right    right pointer
     * @param <T>      data type T
     * @return perform sorting and return the index of pivot
     */
    public static <T extends Comparable<T>> int randomPartition(ArrayList<Actor> actorList, int left, int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(actorList, randomIndex, right);
        return partition(actorList, left, right);
    }

    /**
     * Helper function to swap the elements in the array *
     *
     * @param actorList unsorted ArrayList
     * @param i   index i
     * @param j   index j
     * @param <T> data type T
     */
    public static <T> void swap(ArrayList<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * partition function for quick sort *
     *
     * @param actorList   array to be sorted
     * @param left  left boundary
     * @param right right boundary
     * @param <T>   generic data type T
     * @return pivot index
     */
    public static <T extends Comparable<T>> int partition(ArrayList<Actor> actorList, int left, int right) {
        String pivot = actorList.get(left + right >> 1).getName(); // -> the element in the middle, not the pivot index
        
        while (left <= right) {
            //keep checking left element in the array if is less than pivot, update the left boundary
        	while (actorList.get(left).getName().compareTo(pivot) < 0) { //comparing array values
        		left++;
        	}
     
            //keep checking pivot if is less than the right element in the array, update the right boundary
        	while (actorList.get(right).getName().compareTo(pivot) > 0) {
        		right--;
        	}
        	
            //check left with right 
            //then swap elements and update both boundary
        	if (left <= right) {
        		swap(actorList, left, right);
        		left++;
        		right--;
        	}
        }
        return left;
    }



}


