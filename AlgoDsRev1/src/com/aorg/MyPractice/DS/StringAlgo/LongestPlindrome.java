package com.aorg.MyPractice.DS.StringAlgo;

public class LongestPlindrome {

	/**
	 * @param args
	 * e.g forgeeksskeegfor
	 */
	public static void main(String[] args) {
		try{
			String str = "forgeeksskeegfor";
			new LongestPlindrome().longestPlaindromeBy(str);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void longestPlindrome(String s){
		try{
			int maxLen = 0;
			int len = 0;
			String stri = null;
			for(int i=0; i <s.length() ; i++){
				for(int j = i+1;j < s.length()-1;j++){
					len = j-i;
					String str = s.substring(i,j+1);
					if(isPalindrome(str)){
						if(maxLen < len){
							maxLen = len;
							stri = str;
						}
					}
				}
			}
			System.out.println(maxLen+" > "+stri);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public boolean isPalindrome(String str){
		try{
			if(str.length() == 0 || str.length() == 1){
				return true;
			}
			if(str.charAt(0) == str.charAt(str.length()-1)){
				return isPalindrome(str.substring(1,str.length()-1));
			}
			return false;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public void longestPlaindromeBy(String s){
		try{
			boolean[][] table = new boolean[s.length()][s.length()];
			int maxLen = 0;
			int len = 0;
			String pali = new String();
			if(s.length() == 1 || (s.charAt(0) == s.charAt(1) && s.length() == 2)){
				maxLen = s.length();
			}else{
				/*Here we considering every single character is pallindrome*/
				for(int i = 0;i<s.length();i++){
					table[i][i] = true;
				}
				/*Here we considering every single character and its next character forming palindrome*/
				for(int i=0;i<s.length()-1;i++){
					if(s.charAt(i) == s.charAt(i+1)){
						table[i][i+1] = true;
					}
				}
				for(int i = 3;i<s.length();i++){
					for(int j = 0;j<s.length()-i;j++){
						int len1 = j+i-1;
						if(s.charAt(j) == s.charAt(len1)){
							if(table[j+1][len1-1]){
								table[j][len1] = true;
								if(maxLen < len1){
									maxLen = len1;
									pali = s.substring(j,len1+1);
								}
							}
						}else{
							table[j][len1] = false;
						}
					}
				}
			}
			System.out.println(maxLen+" > "+pali);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void longestString(String str){
		try{
			int lon = 1;
			String s = null;
			for(int i = 0;i<str.length();i++){
				
				String temp = getLongestString(str,i,i);
				if(temp.length() > lon){
					lon = temp.length();
					s = temp;
				}
				String temp1 = getLongestString(str,i,i+1);
				if(temp1.length() > lon){
					lon = temp1.length();
					s = temp1;
				}
			}
			System.out.println(lon+" > "+s);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String getLongestString(String s,int beg,int end){
		try{
			while(beg >= 0 && beg < s.length() && end >= 0 && end < s.length()&& s.charAt(beg) == s.charAt(end)){
					beg--;
					end++;
			}
			return s.substring(beg+1,end);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
