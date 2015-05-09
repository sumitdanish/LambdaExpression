package com.aorg.MyPractice.DS.Puzzle;
/*
 *May 8, 2015
 *SUMMIT
 *9:07:09 PM
 *2015
 *
 */
public class IntegerToString {

	public static void main(String[] args) {
		try{
			Integer num = 1340403056;
			String n = new IntegerToString().integerToString(num);
			System.out.println(n);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	public String integerToString(int num){
		try{
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			int count = 0;
			while(num != 0){
				int n = num % 10;
				if(count != 0 && count % 3 == 0){
					sb = sb.append(",");
				}
				count++;
				sb = sb.append(n != 0 ? String.valueOf(n) : String.valueOf('0'));
				num = num /10;
			}
			return sb.toString();
				
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
