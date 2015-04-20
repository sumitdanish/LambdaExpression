package com.aorg.MyPractice.DS.LeetCode;

public class RegularExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String t = "aa";
			String p = "a*";
			boolean b = new RegularExpression().getExpression(t, p);
			if(b == true){
				System.out.println("Hi...");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean getExpression(String t,String p){
		try{
			if(p.length() == 0){
				return (t.length()== 0);
			}
			if(p.length() == 1 || p.charAt(0) != '*'){
				if((t.length() < 1) || (p.charAt(0) != '.' && t.charAt(0) != p.charAt(0))){
					return false;
				}
				return getExpression(t.substring(1), p.substring(1));
			}else{
				
				int len = t.length();
				int i = -1;
				while((i < len) && (p.charAt(0) == '*' || p.charAt(0) == '.' || p.charAt(0) == t.charAt(i))){
					if(getExpression(t.substring(i+1), p.substring(2))){
						return true;
					}
					i++;
				}
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
}
