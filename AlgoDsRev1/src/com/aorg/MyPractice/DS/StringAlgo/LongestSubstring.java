package com.aorg.MyPractice.DS.StringAlgo;

public class LongestSubstring {

	static int maxSum = Integer.MIN_VALUE;
	public static void main(String[] args){
		try{
			String s = "912312398";
			int len = new LongestSubstring().getSumInEquallyDistanc(s);
			System.out.println(len);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int getSumInEquallyDistanc(String s){
		try{
			int len = 1;
			if(s.length() == 0){
				return 0;
			}
			for(int i = 0;i<s.length();i++){
				String temp = longestSubstring(s,i,i);
				if(len < (temp == null ? 0 :temp.length())){
					len = temp.length();
				}
				String temp1 = longestSubstring(s,i,i+1);
				if((temp == null ? 0 :temp.length()) > len){
					len = temp1.length();
				}
			}
			return len;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public String longestSubstring(String s,int be,int en){
		try{
			int sum1 = 0;
			int sum2 = 0;
			//boolean flag = false;
			while(be>=0 && be<s.length()  && en < s.length()){
				sum1+=Integer.parseInt(String.valueOf(s.charAt(be)));
				sum2+=Integer.parseInt(String.valueOf(s.charAt(en)));
				be--;
				en++;
			}
			String te = s.substring(be+1, en);
			if(te.length() %2 == 0 && sum1 == sum2){
				return te;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
