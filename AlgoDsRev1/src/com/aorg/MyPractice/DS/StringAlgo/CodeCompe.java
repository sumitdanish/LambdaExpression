package com.aorg.MyPractice.DS.StringAlgo;

public class CodeCompe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String str = "Bharti, Bharat, Akash, Bhavya, Chand, Brijesh ,Chetak, Arvind, Bhavna";
			new CodeCompe();
			int len = CodeCompe.plaindrome(str.split(","));
			System.out.println(len);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public static int plaindrome(String[] str){
		try{
			StringBuilder sb = new StringBuilder();
			for(String s : str){
				sb = sb.append(s.trim().charAt(0));
			}
			return plaindrome1(sb.toString());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	public static int plaindrome1(String str){
    	try{
    		int maxLen = 1;
    		for(int i= 0; i <str.length();i++){
    			String temp = longestPalindromeSubstring(str,i,i);
    			if(temp.length() > maxLen){
    				maxLen = temp.length();
    			}
    			String temp1 = longestPalindromeSubstring(str,i,i+1);
    			if(temp1.length() > maxLen){
    				maxLen = temp1.length();
    			}
    		}
    		return maxLen;
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return -1;
    }
    public static String longestPalindromeSubstring(String str,int beg,int end){
    	try{
    	   
    	   while(beg >= 0 && beg < str.length() && end >= 0 && end < str.length() && str.charAt(beg) == str.charAt(end)){
    	   	beg--;end++;
    	   }
    	   return str.substring(beg+1,end);
    	   
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return null;
    }
	
}
