package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		if(string.equals("")) {
			return "";
		}
		char[] a = string.toCharArray();
		char[] b = new char[a.length];
		int index = 0;
		for(int i = a.length - 1; i >= 0; i--) {
			b[index] = a[i];
			index++;
		}
		
		String text = String.valueOf(b);
		// TODO Write an implementation for this method declaration
		return text;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String aka ="";
		String[] splitted = phrase.split("[ -]");
		
		for(String s : splitted) {
			aka += s.substring(0, 1).toUpperCase();
		}
		
		return aka;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideOne == sideThree)
				return true;
			else
				return false;
		}

		public boolean isIsosceles() {
			if ((sideOne == sideTwo && sideOne != sideThree) || 
					(sideTwo == sideThree && sideTwo != sideOne)
					|| (sideOne == sideThree && sideOne != sideTwo))
				return true;
			else
				return false;
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree)
				return true;
			else
				return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		String input = string.toUpperCase();
		char[] a = input.toCharArray();
		int points = 0;							// Store points
		
		for (char c : a) {
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || 
					c == 'L' || c == 'N' || c == 'R' ||  c == 'S' || c== 'T')
				points += 1;
			
			if (c == 'D' || c == 'G')
				points += 2;
			
			if (c == 'B' || c == 'C' || c == 'M' || c == 'P')
				points += 3;
			
			if (c == 'F' || c == 'H' || c == 'V' || c == 'W' || c =='Y')
				points += 4;
			
			if (c == 'K')
				points += 5;
			
			if (c == 'J' || c == 'X')
				points += 8;
			
			if (c == 'Q' || c == 'Z')
				points += 10;
		}
		
		return points;
		
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		String clean = string.replaceAll("[-()\\s.+]","");
		
		if (clean.length() > 10)
			throw new IllegalArgumentException();
			
		char[] a = clean.toCharArray();
		
		for(char c : a) {
			if(Character.isDigit(c) == false) {
				throw new IllegalArgumentException();
			}
			
		}
		if(a[0] > '9' || a[0] < '0') {
			throw new IllegalArgumentException();
		}
		
		if(a[3] > '9' || a[3] < '0') {
			throw new IllegalArgumentException();
		}
			
		return clean;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		
		Map<String, Integer> map = new HashMap<>();
		String sentence = string.toLowerCase();

		for(String word : sentence.split("\\W")) {
			
			if(word.isEmpty()) {
		        continue;
		    }
			
		    if(map.containsKey(word)) {
		        map.put(word, map.get(word)+1);
		    }
		    else {
		        map.put(word, 1);
		    }
		}
		return map;
		
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {

			int start = 0;
			int end = sortedList.size()-1;
			
			while(start<=end)
			   {
			     int mid = (start+end)/2;
			     
			     if(t.compareTo(sortedList.get(mid))==0)
			     {
			         return mid;
			     }
			     if(t.compareTo(sortedList.get(mid))>0)
			     {
			         start = mid+1;
			     }
			    
			     else
			     {
			         end = mid-1;		
			     }
			   }
			   return -1;                //key not found

		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}


	/**
	 * 8. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		// Length of integer
		int length = String.valueOf(input).length();
		
		// Convert to string
		String number = String.valueOf(input);
		char[] digits = number.toCharArray();
		
		int sum =0;
		
		for (char c : digits) {
			int a = Character.getNumericValue(c);
			sum += Math.pow(a, length);
		}
		
		if (sum == input)
			return true;
		else
			return false;
	}

	/**
	 * 9. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		if (string.contentEquals(""))
			return false;
		
        boolean[] contain = new boolean[26]; 
  
        int index = 0; 
  
        // Traverse all characters 
        for (int i = 0; i < string.length(); i++) { 
            
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') 
                index = string.charAt(i) - 'A'; 
  
            else if(string.charAt(i) >= 'a' && string.charAt(i) <= 'z') 
               index = string.charAt(i) - 'a'; 
  
            // Mark current character 
            contain[index] = true; 
        } 
  
        // Return false if any character is unmarked 
        for (int i = 0; i < contain.length; i++) {
            if (contain[i] == false) 
                return false; 
        }
        
        return true; 
	}

	
	/**
	 * 10. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			char[] a = string.toCharArray();
			
			int ascii;
			String rotated = "";
			
			for (int i = 0; i < a.length ; i++) {
				// Check to see if letter
				if (a[i] >= 'A' && a[i] <= 'Z') {
					ascii = (int) a[i] + key;
					if(ascii > 'Z')			
						// Calculate remainder
						ascii = 'A' + (ascii - 'Z') - 1;
					rotated += (char) ascii;
					continue;
				}
				// Check to see if letter
				if (a[i] >= 'a' && a[i] <= 'z') {
					ascii = (int) a[i] + key;
					if(ascii > 'z')
						// Calculate remainder
						ascii = 'a' + (ascii - 'z') - 1;
					rotated += (char) ascii;
					continue;
				}
				// Keeps non-letter chars (a-z) etc
				rotated += a[i];
			}
			return rotated;
		}

	}
	

	/**
	 * 11 & 12. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 11
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {

			char[] a = string.toCharArray();
			int index = 0;
			String encoded = "";
			int count = 0;
			// Traverse all characters
			for (int i = 0; i < string.length(); i++) {

				// Add a space when count = 5;
				if (count == 5) {
					encoded += " ";
					count = 0;
				}

				if (a[i] >= 'A' && a[i] <= 'M') {
					index = a[i] - 'A';
					// Get backwards letter
					int c = 'Z' - index;
					encoded += (char) c;
					count++;
					continue;
				}
				if (a[i] >= 'a' && a[i] <= 'm') {

					index = a[i] - 'a';
					// Get backwards letter	
					int c = 'z' - index;
					encoded += (char) c;
					count++;
					continue;
				}

				if (a[i] >= 'N' && a[i] <= 'Z') {
					index = 'Z' - a[i];
					// Get backwards letter
					int c = 'A' + index;
					encoded += (char) c;
					count++;
					continue;
				}
				if (a[i] >= 'n' && a[i] <= 'z') {
					index = 'z' - a[i];
					// Get backwards letter
					int c = 'a' + index;
					encoded += (char) c;
					count++;
					continue;
				}
				// Checks to see if digit character
				if (a[i] >= '0' && a[i] <= '9') {
					encoded += a[i];
					count++;
				}
			}
			// Remove whites spaces at end and convert to lower case
			return encoded.toLowerCase().trim();
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {

			char[] a = string.toCharArray();
			int index = 0;
			String encoded = "";
			
			// Traverse all characters
			for (int i = 0; i < string.length(); i++) {
				
				if(a[i] == ' ')
					continue;

				if (a[i] >= 'a' && a[i] <= 'm') {
					index = a[i] - 'a';
					// Get backwards letter	
					int c = 'z' - index;
					encoded += (char) c;
					continue;
				}

				if (a[i] >= 'n' && a[i] <= 'z') {
					index = 'z' - a[i];
					// Get backwards letter
					int c = 'a' + index;
					encoded += (char) c;
					continue;
				}
				// Checks to see if digit character
				if (a[i] >= '0' && a[i] <= '9') {
					encoded += a[i];
				}
			}
			return encoded;
		}
		
	}

	/**
	 * 13. (Optional) The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		// remove - and do toCharArray and replace x value with 10 check length too
		
		string = string.replaceAll("-", "");
		System.out.println(string);
		char[] a = string.toCharArray();
		
		for(char c : a) {
			if (!Character.isDigit(c) ) {
				if(c != 'X') 
					return false;
			}
			
		}
		
		// If longer than 10, return false
		if (a.length > 10)
			return false;
		
		int value = 0;
		int pow = 10;
		
		for (int i = 0; i < a.length; i++) {
			
			System.out.println(a[i]);	
			int y = a[i] - '0';
			if (a[i] == 'X') {
				y = 10;	
			}
			value += y * pow;
			pow--;
		}
		
		// If does not = 0, return false
		if (value%11 != 0)
			return false;
		
		return true;
	}


	/**
	 * 14. (Optional) Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	
	/**
	 * 15. (Optional) Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		string = string.replace("?", "");
		String[] split = string.split(" ");
		int i = 0;
		
		// Array to store two int values 
		int[] numbers = new int[2];
		
		for(String s : split) {
			System.out.println(s);
			try {
		        int a = Integer.parseInt(s);
		    } 
			catch (NumberFormatException | NullPointerException nfe) {
		        continue;
		    }
			numbers[i] = Integer.parseInt(s);
			i++;
		}
		
		int a = numbers[0];
		int b = numbers[1];
		
		
		for(String s : split) {
			if (s.equals("plus"))
				return a + b; 
			if(s.equals("minus"))
				return a - b;
			
			if(s.equals("multiplied"))
				return a * b;
			
			if(s.equals("divided"))
				return a / b; 
		}

		return 0;
	}

}
