/**
 * Assignment 1: Word Play

You will write a program to transform words from a file into another form, such as replacing vowels 
with an asterix.

Specifically, you should do the following.

Create a new class called WordPlay.
Write a method isVowel that has one Char parameter named ch. 
This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or 
the uppercase versions) and false otherwise. You should write a tester method 
to see if this method works correctly. For example, isVowel(‘F’) should return false, 
and isVowel(‘a’) should return true.
Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. 
This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) 
replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. 
Be sure to call the method isVowel that you wrote and also test this method.
Write a method emphasize with two parameters, a String named phrase and a character named ch. 
This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) 
replaced by ‘*’ if it is in an odd number location in the string (first character has index 0, 
third character has index 2, etc.), or ‘+’ if it is in an even number location in the string 
(second character has index 1, fourth character has index 3, etc.).

For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, 
and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”. 
Be sure to test this method.
 * @author sling
 *
 */

/**
 * 
 * NOTE:  The lecture gave example using StringBuilder object. But, it may be better to use StringBuffer.
 * While StringBuilder is faster, it is not thread safe.
 */


public class WordPlay { //includes testing method main here

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPlay wordPlayObject = new WordPlay();
		System.out.println("output of isVowel() " + wordPlayObject.isVowel('E') + " should be : true.");
		System.out.println("output of isVowel() " + wordPlayObject.isVowel('f') + " should be : false.");
		System.out.println("output of replaceVowels() " + 
							wordPlayObject.replaceVowels("Hello World", '*') +
							" should be :" + "H*ll* W*rld.");
		System.out.println("output of emphasize() " +
							wordPlayObject.emphasize("dna ctgaaactga", 'a') + 
							" should be : " + 
							"dn* ctg+*ctg+");
		System.out.println("output of emphasize() " + 
							wordPlayObject.emphasize("Mary Bella Abracadabra", 'a') +
							"should be : " +
							"M+ry Bell+ +br*c*d*br+");
	}//checked April 4, 2016.

	public boolean isVowel(char ch){
		String vowels = "aeiouAEIOU"; //String of vowels in which we will look to see if ch is there.
		if (vowels.indexOf(ch) >= 0) return true; //String.indexOf() gives -1 when not found.
		return false;
	}//end isVowel //checked April 3, 2016
	
	
	public String replaceVowels (String phrase, char ch){
		StringBuffer tempPhrase = new StringBuffer(); //use StrignBuilder to store local mutable strings.
		char chTest;
		for (int i = 0; i < phrase.length(); i++ ){
			chTest = phrase.charAt(i); // get the character at this position to test for being vowel
			if (isVowel(chTest)){
				tempPhrase.append(ch);
			} else {
				tempPhrase.append(chTest);
			}						
		}		
		return tempPhrase.toString();
	}//end replaceVowels() //checked April 4, 2016
	
	public String emphasize (String phrase, char ch){
		char chLower = Character.toLowerCase(ch); // ** Since rule of emphasize applies equally to lower
		char chUpper = Character.toUpperCase(ch); // ** and upper ch we need to check against both.
		StringBuffer tempPhrase = new StringBuffer(); //use StrignBuilder to store local mutable string to return.
		char tempChar; // this is local variable that s used for char at the i-th position of phrase
		for (int i=0; i< phrase.length(); i++){
			tempChar = phrase.charAt(i);
			if (tempChar==chLower || tempChar==chUpper){
				if (i % 2 == 0){ //odd positions in the string phrase
					tempPhrase.append('*');
				} else { //even positions in the string phrase
					tempPhrase.append('+');
				}					
			} else { // if ch not found at position i in the string then just add that to the return string
				tempPhrase.append(tempChar);
			}
		}
		return tempPhrase.toString(); //Note: tempPhrase is StringBuilder object and not a String. 
	}//end emphasize //checked April 4, 2016
	
	
	
} // end class WordPlay
