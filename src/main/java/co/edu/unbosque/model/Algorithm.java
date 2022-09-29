/**
 * The package of the class
 */
package co.edu.unbosque.model;
/**
 * Class where the algorithms KMP and BM are developed
 * 
 * @author Hernan Alvarado, Kevin Pinzón, Omar Santos
 *
 */
public class Algorithm {

	/**
	 * Empty constructor of the class
	 */	
	public Algorithm() {}
	
	/**
	 * Method that develops the search by the KMP algorithm
	 * 
	 * @param text String of the file imported
	 * @param search String of the character(s) that will be finded
	 * @return String of the character(s) that the user searched
	 */
	// J LENGTH OF THE SEARCH
	public String kmpAlgorithm(String text, String search) {
		StringBuilder builder = new StringBuilder(); // 1
		int nums [] = new int [search.length()]; // 1
		nextPosition(search, nums); // 3 + 9J
		int counter = 0; 	// 1
		int index = 0; 	// 1
		while(kmp(text, search, nums, index) != -1) { // 4 + 8J
			builder.append(kmp(text, search, nums, index) + ",");  // (4 + 8J) * N 
			index = kmp(text, search, nums, index) +1; // (4 + 8J) * N
			kmp(text, search, nums, index); // (4 + 8J) * N
			counter ++; // N
		}
		return counter + "," + builder.toString(); // 1
		/*
		 *  1 + 1 + 3 + 9N + 1 + 1 + 4 + 8J + (4 + 8J) * N + (4 + 8J) * N + (4 + 8J) * N + N + 1 
		 *  8J + 9N + 11 + 3N (4+8J) + N + 1
		 *  8J + 10 N + 12 + 3N (4 + 8J)
		 */
	}
	
	/**
	 * Method that develops the search by the KMP algorithm
	 * 
	 * @param text String of the file imported
	 * @param search String of the character(s) that will be finded
	 * @return String of the character(s) that the user searched
	 */
	
	public String bmAlgorithm(String text, String search) {
		StringBuilder builder = new StringBuilder(); 	// 1
		int chars [] = new int [256]; 	// 1
		setValues(search, chars); // 4N + 4
		int counter = 0; // 1
		int index = 0; // 1
		while(bm(text, search, chars, index) != -1) { // (2N + (N * 3N + 5) + 2) + 1
			builder.append(bm(text, search, chars, index) + ","); // (2N + (N * 3N + 5) + 2) * N
			index = bm(text, search, chars, index) +1; // (2N + (N * 3N + 5) + 2) * N
			bm(text, search, chars, index); // (2N + (N * 3N + 5) + 2) * N
			counter ++; // N
		}
		return counter + "," + builder.toString(); // 1
		// 1 + 1 + 4N + 4 + 1 + 1 + (2N + (N * 3N + 5) + 2) + 1 + (3N * (2N + (N * 3N + 5) + 2)) + N + 1
		// 5N + (2N + (LOG N * 3N + 5) + 2) + (3N * (2N + (N * 3N + 5) + 2)) +  10 
		// Big o (N^2)
	}
	
	
	/**
	 * Method that searches the position of the character(s) requiered by the user
	 * 
	 * @param text String of the file imported
	 * @param search String of the character(s) that will be finded
	 * @param nums Unidimensional array that contains the positions of the searches
	 * @param index Initial position to make the search
	 * @return Integer of the position of what the user searched
	 */
	public int kmp(String text, String search, int nums [], int index) {
		int k = 0; // 1
		while(index < text.length() && k < search.length()) { // 2J
			if(k == -1 || text.charAt(index) == search.charAt(k)) { // 2J
				index ++; // J
				k ++; // J
			}else { 
				k = nums[k]; // J
			}
		}
		if(k == search.length()) // 1
			return index - k; // 1
		return -1; // 1
		// 1 + J + J + J + J + J + 1 + 1 + 1 -> 4 + 8J
	}
	
	/**
	 * Method that searches the position of the character(s) requiered by the user
	 * 
	 * @param text String of the file imported
	 * @param search String of the character(s) that will be finded
	 * @param chars Unidimensional array that contains the positions of the searches
	 * @param index Initial position to make the search
	 * @return Integer of the position of what the user searched
	 */
	public int bm(String text, String search, int chars [], int index) {
		int skip; // 1
		for(int i = index; i < text.length() - search.length(); i += skip) { // N
			skip = 0; // N
			for(int j = search.length() -1; j >= 0; j--) { // 1 + N +1 + N -> 2N + 2
				if(search.charAt(j) != text.charAt(i + j)) { // N
					skip = j - chars[text.charAt(i + j)]; // 1
					skip = skip < 1? 1 : skip; // 1
					break; 
				}
			}
			// 2N + 2 + N + 1 + 1 -> 3N + 5
			if(skip == 0) return i; // N
		}
		return -1; // 1
		// 1 + (N * 3N + 5) + N +  N + 1 -> 2N + (N * 3N + 5) + 2
	}
	
	/**
	 * Method that determines which character(s) are inside the search, based on the characters in the ASCII table. 
	 * In order to take them into account when performing the search
	 * 
	 * @param text String with the search that will be done
	 * @param chars Unidimensional array which contains the indices of the matches
	 */
	public void setValues(String text, int chars []) {
		for(int i = 0; i < chars.length; i++) //  1 + N + 1 + N -> 2N + 2
			chars[i]--; // N
		for(int i = 0; i < text.length(); i++) // 1 + N + 1 + N -> 2N + 2
			chars[text.charAt(i)] = i; // N
		// 2N + 2 + N + 2N + 2 + N -> 6N + 4
	}
	
	/**
	 * Method that modifies the initial positions of the characters, in case there are repeated cases inside the initial search 
	 * 
	 * @param content String of the search that will be done
	 * @param nums Unidimensional array of the search length
	 * @return The modified position 
	 */
	public int [] nextPosition(String content, int nums []) {
		nums[0]--;     // 1
		int i = -1; // 1
		int j = 0; // 1
		while(j < content.length() -1) { // J
			if(i == -1 || content.charAt(j) == content.charAt(i)) { // J
				nums[j ++] = i++; // J
				if(content.charAt(j) == content.charAt(i)) // J
					nums[j] = nums[i]; // J
			}else {
				i = nums[i]; // J
			}
		}
		// 1 + 1 + 1 + J + J + J + J + J + 1-> 3 + 10J
		return nums; // 1
	}
}