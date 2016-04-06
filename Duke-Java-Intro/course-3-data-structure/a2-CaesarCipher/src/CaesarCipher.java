import java.io.*;

public class CaesarCipher {
	// use the default constructor
	// we need to write the encrypt and decrypt functions 
	
	/**
	 * Write the method encrypt that has two parameters, 
	 * a String named input and an int named key. This method 
	 * returns a String that has been encrypted using the Caesar 
	 * Cipher algorithm explained in the videos. 
	 * Assume that all the alphabetic characters are uppercase letters. 
	 * For example, the call 
	 * encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)
	 * should return the string 
	 * “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
	 * @param args
	 */
	
	 /* Modify the encrypt method to be able to handle both uppercase and lowercase letters. 
	  * For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and 
	  * encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”. 
	  * Be sure to test the encrypt method.
	  */
	
	/**
	 * 
	 * @param message : the message string to be encrypted
	 * @param key : the integer by which the alphabets needs to be shifted. Must be >= 0.
	 * @return encrypted message string
	 */
	public String encrypt(String message, int key){
	StringBuffer encryptedMessage = new StringBuffer(); //use StringBuffer to store local mutable strings.
	String alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String alphabetsLower = alphabets.toLowerCase();
	String shiftedAlphabets;
	String shiftedAlphabetsLower;
	
	// We think A..Z in a circle with A at position 0 and Z at position 25.
	// if key is more than 26 we would need to wrap the number modulo 26.
	// Key = 0 and Key = 26 should be no shift and Key = 1 and Key = 27 should be shift by 1.
	int key26; //key26 will be generated from key that is larger than 26
	if (key < 0){
		throw new IllegalArgumentException("Key " + key + " should be >=0.");
	} else {
		key26 = key % 26; //if key is more than 26, just wrap around.
		shiftedAlphabets = alphabets.substring(key26) + alphabets.substring(0,key26);
	}
	shiftedAlphabetsLower = shiftedAlphabets.toLowerCase();
//	System.out.println(alphabets); //used when checking the program.
//	System.out.println(shiftedAlphabets);
	
	char testChar;
	int indexUpper;
	int indexLower;
	for(int i = 0; i< message.length(); i++){
		testChar = message.charAt(i);
		indexUpper = alphabets.indexOf(testChar); 
			//Note: if the char is not in the alphabets indexU and indexL will be -1
		indexLower = alphabetsLower.indexOf(testChar);
		if (indexUpper >= 0)
		{
			encryptedMessage.append(shiftedAlphabets.charAt(indexUpper));
		} else if (indexLower >= 0)
		{
			encryptedMessage.append(shiftedAlphabetsLower.charAt(indexLower));
		} else {
			encryptedMessage.append(testChar);
		}		
	}		
	return encryptedMessage.toString();
	} //end encrypt()
	
	public String encryptFile(String filename, int key){
	
		CaesarCipher cs = new CaesarCipher();
		// The name of the file to open.
        String fileName = filename;
        // This will reference one line at a time
        String line = null;
        StringBuffer encryptedFile  = new StringBuffer();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
               // System.out.println(line);
            	encryptedFile.append( cs.encrypt(line, key) );
            	encryptedFile.append( "\n" ); //need to put back end of line character.
            }             
            bufferedReader.close();   // Always close files.      
        }
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + fileName + "'");                  
            // Or we could just do this: ex.printStackTrace();
        }
   	 return encryptedFile.toString();	
	}
		
			

	
	public static void main(String[] args) { //this is the tester function for me.
		// TODO Auto-generated method stub
		
		CaesarCipher cs = new CaesarCipher(); 
				//get a CaesarCipher object for using the methods above.
		
		int key = 23;
		System.out.println("Encrypted Message: " + 
				cs.encrypt("FIRST Legion ATTACK EAST FLANK!", key).toString());
				
		System.out.println( cs.encryptFile("src/Files/testFile.txt", key) );
	}
}
