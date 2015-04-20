package com.aorg.MyPractice.DS.MathmaticalNotations;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFixNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String st = "A*(B+C–D/E)/F"; // OP -> ABC+DE/– *F/
			new InfixToPostFixNotation().infixToPostFix(st.toCharArray());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void infixToPostFix(char[] ch){
		try{
			Stack<Character> st = new Stack<Character>();
			HashMap<Character,Integer>  map = new HashMap<Character, Integer>();
			map.put('+',1);
			map.put('-',1);
			map.put('*',2);
			map.put('/',2);
			map.put('^',3);
			for(int i=0;i<ch.length;i++){
				if(ch[i] >= 'A' && ch[i] <='Z'){
					System.out.print(ch[i]);
					//st.push(ch[i]);
				}else{
					if(ch[i] == '('){
						st.push(ch[i]);
					}else 
						if(ch[i] == ')'){
						char x = st.peek();
						while(!st.isEmpty() && x!='('){
								x = st.pop();
								System.out.print(x != '('?x:' ');
							}
					}else{
						while(!st.isEmpty()&&map.containsKey(ch[i]) && map.containsKey(st.peek()) && map.get(ch[i]) <= map.get(st.peek())){
							System.out.print(st.pop());
						}
						st.push(ch[i]);
					}
				}
			}
			while(!st.isEmpty()&&st.peek()!='('){
				System.out.print(st.pop());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
