package co.edu.unbosque.model;

public class Modelo {

	public Modelo() {}
	
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
	
	public void setValues(String text, int chars []) {
		for(int i = 0; i < chars.length; i++)
			chars[i]--;
		for(int i = 0; i < text.length(); i++)
			chars[text.charAt(i)] = i;
	}
	
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