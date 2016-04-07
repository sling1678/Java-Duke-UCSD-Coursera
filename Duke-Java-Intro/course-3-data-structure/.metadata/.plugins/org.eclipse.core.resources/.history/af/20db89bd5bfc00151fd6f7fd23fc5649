import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 
 * @author sling
 *
 * This assignments:
 * Write a new class WordLengths that has the following methods
 * 
 * Method void countWordLengths(String filename, int[] counts) that reads the file and 
 * computes the number of words of various lengths. Rules for counting lengths:
 * (1) ignore first or last character if that is not a letter - this will skip quotes
 * (2) there would be more complicated rules in a real program, but ignore those complications.
 * (3) for any words that are larger than the length of array counts[], then count that word 
 * in the counts[count.length-1] element.
 * 
 * Method void testCountWordLengths() should create a FileReader so you can select a file, and 
 * creates a counts integer array of size 31. This method should call countWordLengths 
 * with a file and then print the number of words of each length. Test it on the small 
 * file smallHamlet.txt shown below.
 * 
 * Method int indexOfMax(int[] values) that returns the index element of the largest element 
 * in the values. Use this in the testCountWordLengths() to determine the most common word 
 * length in the file. Test this on file smallHamlet.txt.
 */



public class WordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WordLengths wl = new WordLengths();
		
		int [] counts = new int[31];
		wl.countWordLengths("src/Files/smallHamlet.txt", counts);
		
		for (int i=1; i<counts.length; i++){ //no need to print 0 length word count
			System.out.print( counts[i] + "; " );
		}
		System.out.println("");
		
		System.out.println("most common length of words: " + wl.indexOfMax(counts));
		
	}
	
	public void countWordLengths(String filename, int[] counts){
		//First make BufferedReader to read one line at a time.		
        String line = null;		
		try {
            // FileReader reads text files in the default encoding.
            // FileReader fileReader = new FileReader(fileName);
            // Wrap FileReader in BufferedReader.
			// I will BufferedReader for reading the file and Scanner to parse each line for words
			
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            while((line = bufferedReader.readLine()) != null) {
               	Scanner scan = new Scanner(line);
            	while (scan.hasNext()){
            		String word = scan.next();
            	//	System.out.println(word); //check if words are being produced properly
            	//	Logic for the rules
            	// get the proper length of the word
            		int len = word.length();
            		if ( !Character.isLetter( word.charAt(0) ) ) len--;
            		if ( !Character.isLetter( word.charAt(word.length() - 1) ) ) len--;
            		if (len < counts.length && len>=0){ // make sure len did not go below 0.
            			counts[len]++;
            		} else {
            			counts[counts.length-1]++;
            		}
            		
            	}
            	scan.close(); //must close the scanner
          	// comment out the following line; it is here for checking if the lines are being read
            //	System.out.println(line);
            }             
            bufferedReader.close();   // close file reading     
        }
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file '" + filename + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + filename + "'");                  
            // Or we could just do this: ex.printStackTrace();
        }// end try/catch block		
						
	}//end countWordLengths()
		

	public int indexOfMax(int[] values){
		int index = 0;
		int max = values[0];
		for (int i=0; i< values.length; i++){
			if (max < values[i]) {
	//			max = values[i];
				index = i;
			}
			
		}
		return index;
	}
	
	
	
	
} //end of class
