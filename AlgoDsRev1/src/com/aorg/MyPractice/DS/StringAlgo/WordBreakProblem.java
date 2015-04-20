package com.aorg.MyPractice.DS.StringAlgo;

import java.util.HashSet;

public class WordBreakProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String str = "leetcode";
			HashSet<String> dict = new HashSet<String>();
			dict.add("leet");
			dict.add("code");
			boolean b = new WordBreakProblem().isBreakableDP(str, dict);
			if(b){
				System.out.println("Is breakable in the dictionary word");
			}else{
				System.out.println("Its not breakable in the dictionary");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean isBreakable(String s,HashSet<String> dict,int start) {
		try{
			if(start == s.length()){
				return true;
			}
			for(String w : dict){
				int len = w.length();
				int end = 0;
				end  = len+start;
				String str = s.substring(start,end);
				if(str.equals(w)){
					if(isBreakable(s, dict,end)){
						return true;
					}
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	private boolean isBreakableDP(String str,HashSet<String> set){
		try{
			boolean[] table = new boolean[str.length()+1];
			for(int i = 0;i<str.length();i++){
				for(String w : set){
					int len = w.length();
					int end = len+i;
					if(end > str.length()){
						continue;
					}
					String s  =str.substring(i,end);
					if(end <= str.length() && s.equals(w)){
						table[end] = true;
					}
				}
			}
			return table[str.length()];
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
}
