package com.aorg.MyPractice.DS.StringAlgo;

public class MaxLenUniqueCharecter {

	/**
	 * @param args
	 * 
	 * if we will consider the constant function for isValid 
	 * function then time complexity of bellow algoritham id=s O(N) 
	 * 
	 */
	public static void main(String[] args) {
		try{
			String str = "aabacbebebe";
			int k = 3; // MAx Length of unique character in the string
			new MaxLenUniqueCharecter().countMaxUniquCharecter(str, k);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public boolean isValid(int[] count,int val){
		try{
			int v = 0;
			for(int i = 0;i < count.length ; i++){
				if(count[i] > 0){
					v++;
				}
			}
			return (val >=v);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public void countMaxUniquCharecter(String str,int k){
		try{
			int co = 0;
			int current_start = 0;
			int current_end = 1;
			int max_window_size=0;
			int max_start = 0;
			int[] count = new int[str.length()];
			for(int i = 0 ; i< str.length() ; i++){
				if(count[str.charAt(i) - 'a'] == 0){
					co++;
				}
			}
			if(co < k){
				System.out.println("No String is matched");
				return;
			}
			count[str.charAt(0) - 'a']++;
			for(int i = 1;i<str.length();i++){
				count[str.charAt(i) - 'a']++;
				current_end++;
				while(!isValid(count,k)){
					count[str.charAt(current_start) - 'a']--;
					current_start++;
				}
				int size = current_end - current_start;
				if(size > max_window_size){
					max_window_size = size;
					max_start = current_start;
				}
			}
			System.out.println(str.substring(max_start,(max_start+max_window_size))+" > "+max_window_size);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
