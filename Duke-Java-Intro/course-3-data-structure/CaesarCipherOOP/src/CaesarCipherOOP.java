/**
 * Create the CaesarCipher class with the following parts:
 * Private fields for the alphabet and shiftedAlphabet.
 * Write a constructor CaesarCipher that has one int parameter key. 
 * This method should initialize all the private fields of the class.
 * Write an encrypt method that has one String parameter named input. 
 * This method returns a String that is the input encrypted using shiftedAlphabet.
 * Write a decrypt method that has one String parameter named input. 
 * This method returns a String that is the encrypted String decrypted using the key 
 * associated with this CaesarCipher object. One way to do this is to create another 
 * private field mainKey, which is initialized to be the value of key. 
 * Then you can create a CaesarCipher object within decrypt: 
 * CaesarCipher cc = new CaesarCipher(26 - mainKey); and call cc.encrypt(input).
 * @author sling
 *
 */
/*
 * @param 
 * alphabets - the alphabets in original order
 * shiftedAlphabets - the shifted alphabets, shifted by amount given by key
 * key - the integer by which the alphabets are shifted
 */
public class CaesarCipherOOP {

	// instance variables
	private String alphabets;
	private String shiftedAlphabets;
	private int key; //this should be (0 <= key <= 26). key=0 and key=26 : no shift.
	
	// constructor that takes an argument, key, and initializes the instance variables.
	
	public CaesarCipherOOP (int key){
		this.key = key;
		if (key < 0 || key > 26) throw new IllegalArgumentException(
				"Illegal key: " + key + " shound be >=0 and <=26.");
		alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabets = alphabets.substring(key) + alphabets.substring(0, key);
	}//checked april 6, 2016
	
	// Methods
	public String encrypt (String input){
		StringBuffer encryptedMessage = new StringBuffer();
		String alphabetsLower = alphabets.toLowerCase();
		String shiftedAlphabetsLower = shiftedAlphabets.toLowerCase();
		int indexUpper;
		int indexLower;
		for (int i=0; i<input.length(); i++){
			indexUpper = alphabets.indexOf(input.charAt(i)); // value = -1 if not here
			indexLower = alphabetsLower.indexOf(input.charAt(i)); // value = -1 if not here
			if (indexUpper >= 0) encryptedMessage.append(shiftedAlphabets.charAt(indexUpper));
			if (indexLower >= 0) encryptedMessage.append(shiftedAlphabetsLower.charAt(indexLower));
			if (indexUpper < 0 && indexLower < 0) encryptedMessage.append(input.charAt(i));
						// just copy this character since it is not in alphabets		
		}//end for
				
		return encryptedMessage.toString();
	}//end encrypt//checked april 6, 2016
	
	public String decrypt (String input){
		int decryptKey = 26-key;
		CaesarCipherOOP cc = new CaesarCipherOOP(decryptKey);
		return cc.encrypt(input);		
	}//end decrypt //checked april 6, 2016
	
	
}//checked april 6, 2016
