Assignment 1: Word lengths

You will write a program to figure out the most common word length of words from a file. To solve this problem you will need to keep track of how many words from a file are of each possible length. You should group all words of length 30 or more together, and you should not count basic punctuation that are the first or last characters of a group of characters.

Specifically, you should do the following:

Create a new class called WordLengths.
Write a void method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts. This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.
- For example, after this method executes, counts[k] should contain the number of words of length k.

- If a word has a non-letter as the first or last character, it should not be counted as part of the word length. For example, the word And, would be considered of length 3 (the comma is not counted), the word “blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is). Note that we will miscount some words, such as “Hello,” which will be counted as 6 since we don’t count the double quotes but will count the comma, but that is OK as there should not be many words in that category.

- For any words equal to or larger than the last index of the counts array, count them as the largest size represented in the counts array.

- You may want to consider using the Character.isLetter function that returns true if a character is a letter, and false otherwise. For example, Character.isLetter(‘a’) returns true, and Character.isLetter(‘-’) returns false.

Write a void method testCountWordLengths that creates a FileResource so you can select a file, and creates a counts integer array of size 31. This method should call countWordLengths with a file and then print the number of words of each length. Test it on the small file smallHamlet.txt shown below.
Write a method indexOfMax that has one parameter named values that is an integer array. This method returns the index position of the largest element in values. Then add code to the method testCountWordLengths to call indexOfMax to determine the most common word length in the file. For example, calling indexOfMax after calling countWordLengths on the file smallHamlet.txt should return 3.
First test your program on a small file, such as this simple file shown called smallHamlet.txt:

Laer. My necessaries are embark'd. Farewell.

And, sister, as the winds give benefit

Note this file has words that are:

2 words of length 2: My as

3 words of length 3: are And the

2 words of length 4: Laer give

1 word of length 5: winds

1 word of length 6: sister

1 word of length 7: benefit

2 words of length 8: embark’d Farewell

1 word of length 11: necessaries