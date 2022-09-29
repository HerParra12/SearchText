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
	public String kmpAlgorithm(String text, String search) {
		StringBuilder builder = new StringBuilder(); 
		int nums [] = new int [search.length()]; 
		nextPosition(search, nums); 
		int counter = 0; 	
		int index = 0; 	
		while(kmp(text, search, nums, index) != -1) {
			builder.append(kmp(text, search, nums, index) + ","); 
			index = kmp(text, search, nums, index) +1; 
			kmp(text, search, nums, index); 
			counter ++; 
		}
		return counter + "," + builder.toString();
	}
	
	/**
	 * Method that develops the search by the KMP algorithm
	 * 
	 * @param text String of the file imported
	 * @param search String of the character(s) that will be finded
	 * @return String of the character(s) that the user searched
	 */
	public String bmAlgorithm(String text, String search) {
		StringBuilder builder = new StringBuilder(); 	
		int chars [] = new int [256]; 	
		setValues(search, chars); 
		int counter = 0; 
		int index = 0;
		while(bm(text, search, chars, index) != -1) { 
			builder.append(bm(text, search, chars, index) + ",");
			index = bm(text, search, chars, index) +1; 
			bm(text, search, chars, index); 
			counter ++; 
		}
		return counter + "," + builder.toString();
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
		int k = 0; 
		while(index < text.length() && k < search.length()) {
			if(k == -1 || text.charAt(index) == search.charAt(k)) { 
				index ++; 
				k ++; 
			}else { 
				k = nums[k]; 
			}
		}
		if(k == search.length()) 
			return index - k; 
		return -1; 
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
		int skip; 
		for(int i = index; i < text.length() - search.length(); i += skip) { 
			skip = 0;
			for(int j = search.length() -1; j >= 0; j--) { 
				if(search.charAt(j) != text.charAt(i + j)) {
					skip = j - chars[text.charAt(i + j)]; 
					skip = skip < 1? 1 : skip; 
					break; 
				}
			}
			if(skip == 0) return i;
		}
		return -1; 
	}
	
	/**
	 * Method that determines which character(s) are inside the search, based on the characters in the ASCII table. 
	 * In order to take them into account when performing the search
	 * 
	 * @param text String with the search that will be done
	 * @param chars Unidimensional array which contains the indices of the matches
	 */
	public void setValues(String text, int chars []) {
		for(int i = 0; i < chars.length; i++) 
			chars[i]--;
		for(int i = 0; i < text.length(); i++) 
			chars[text.charAt(i)] = i; 
	}
	
	/**
	 * Method that modifies the initial positions of the characters, in case there are repeated cases inside the initial search 
	 * 
	 * @param content String of the search that will be done
	 * @param nums Unidimensional array of the search length
	 * @return The modified position 
	 */
	public int [] nextPosition(String content, int nums []) {
		nums[0]--; 
		int i = -1; 
		int j = 0; 
		while(j < content.length() -1) { 
			if(i == -1 || content.charAt(j) == content.charAt(i)) { 
				nums[j ++] = i++; 
				if(content.charAt(j) == content.charAt(i))
					nums[j] = nums[i]; 
			}else {
				i = nums[i]; 
			}
		}
		return nums; 
	}
}