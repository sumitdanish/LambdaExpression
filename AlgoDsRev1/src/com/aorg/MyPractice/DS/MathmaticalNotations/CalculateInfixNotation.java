package com.aorg.MyPractice.DS.MathmaticalNotations;

import java.util.Stack;

public class CalculateInfixNotation {

	/**
	 * 	((15/(7-(1 + 1)))*3)-(2+(1+1))
	 * */
	 // 	- * / 15 - 7 + 1 1 3 + 2 + 1 1
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			String expre = "-*/15-7+113+2+11";
			int res = new CalculateInfixNotation().infixCal(expre.toCharArray());
			System.out.println(res);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private int infixCal(char[] ch){
		try{//"-*/15-7+113+2+11";
			Stack<Integer> st = new Stack<Integer>();
			for(int i = ch.length-1;i>=0;i--){
				if(ch[i]>='0'&&ch[i]<='9'){
					st.push(Integer.parseInt(String.valueOf(ch[i])));
				}else{
					int op1 = st.pop();
					int op2 = st.pop();
					int res = 0;
					if(ch[i] == '+'){
						res = op1 + op2;
					}else if(ch[i] == '*'){
						res = op1 * op2;
					}else if(ch[i] == '-'){
						res = op1 - op2;
					}else{
						res = op1 / op2;
					}
					st.push(res);
					System.out.println(res);
				}
			}
			return st.pop();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
