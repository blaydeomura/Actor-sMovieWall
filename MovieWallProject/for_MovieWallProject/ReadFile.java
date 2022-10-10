package for_MovieWallProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "/Users/blaydeomura/documents/CS245Documents/project1/Project1File.csv";
		
		String line = "";
		
		//ArrayList<Actor> actorList = new ArrayList<Actor>();
		ArrayList<String> listTest = new ArrayList<String>(); //arrayList test to see if reading in file works
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			//skip row one
			br.readLine();
			
			while ((line = br.readLine()) != null) { //While br has next line to read
				
				//Splitting right at cast column index
				String[] values = line.split("\\["); //values[1] gets the 3rd column

				//Need to convert castColumn to String
				String cast = values[1];
				
				
				int startChar = cast.indexOf("character"); // returns index of character starts
				
				ArrayList<String> list = new ArrayList<String>();
				
				int startCharName = startChar + 15; //beggining of character Name 
				
				int startName = cast.indexOf("name");
				
				int startActorName = startName + 10;
				
				
				while (startChar > 0 ) { //change upper bounds to 0
					int endChar = cast.indexOf("\"", startCharName); //indexOf(string, start search from)
					
					String role = cast.substring(startCharName, endChar); //(start index, end index)
					list.add(role); //just checking to see if any value recorded
					
					
					int endActorName = cast.indexOf("\"", startActorName);
					
					String nameList = cast.substring(startActorName, endActorName);
					
					list.add(nameList);
					
					break;
					
				}
				
				System.out.println(line);
				
				System.out.println(cast);
		
				System.out.println(list.toString());

				
				break; //i know you hate this, but just to test first line of file
				

				
			}

		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}}



//initilize castColumnString to be split into castColumnArr to split again
//String[] castColumnArr;

////Creating arr where each field is seperated into arr
////essentially reading JSON file part
//castColumnArr = castColumnString.split(":|,");
//
//
//System.out.println(line); //printing out original first line
//System.out.println(castColumnString); // printing out cast column of first line (test)
//
//System.out.println(castColumnArr[2]); //value we want to search for (test)
//System.out.println(castColumnArr[3]); //value we want when ""character"" is found
//
//for (int i = 0; i < castColumnArr.length; i++) { //iterate through castColumnArr
//	if (castColumnArr[i].equals("\"\"character\"\"")) { //if castColumnArr[i] = to ""character""
//		listTest.add(castColumnArr[i+1]); //add value next of it to listTest
//	}
//}
//
//System.out.println(listTest.get(0)); //testing to see if anything was added to arrayList
