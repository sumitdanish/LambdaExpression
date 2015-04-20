package com.aorg.MyPractice.DS.StringAlgo;

import java.io.File;
import java.util.Date;
import java.util.Scanner;


public class TernaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Date d1 = new Date();
			long t1	= d1.getTime();
			Scanner sc = new Scanner(new File("C:\\Users\\SU915198\\Desktop\\dict.txt"));
			TernaryNode ternayNode = null;
			TernaryTree tn = new TernaryTree();
			while(sc.hasNext()){
				ternayNode = tn.insertInto(sc.next().toString(), ternayNode,0);
			}
			boolean isPresent = tn.isPresent(ternayNode,"zymotize",0);
			if(isPresent){
				System.out.println("Its Present");
			}else{
				System.out.println("Try agian");
			}
			Date d2 = new Date();
			long t2 = d2.getTime();
			System.out.println("Total time for execution : "+(t2-t1));
			int longestLen = tn.getLongestString(ternayNode);
			System.out.println(longestLen);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	public int getLongestString(TernaryNode tn){
		try{
			if(tn == null){
				return 0;
			}
			return getMax(getLongestString(tn.getLeft()),
					getMax(getLongestString(tn.getEq())+1,getLongestString(tn.getRight())));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}

	
	public int getMax(int a,int b){
		try{
			return a > b ? a : b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
	public boolean isPresent(TernaryNode tn,String word,int pos){
		try{
			if(tn == null){
				return false;
			}else if(tn.getVal() > word.charAt(pos)){
				return isPresent(tn.getLeft(), word, pos);
			}else if(word.charAt(pos)>tn.getVal()){
				return isPresent(tn.getRight(), word, pos);
			}else{
				if(pos == word.length()-1){
					return true;
				}else{    
					return isPresent(tn.getEq(), word, pos+1);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	
	public TernaryNode insertInto(String word,TernaryNode tn,int pos){
		try{
			if(tn == null){
				tn = new TernaryNode(word.charAt(pos),false,null,null,null);
			}
			if(tn.getVal() < word.charAt(pos)){
				tn.setRight(insertInto(word, tn.getRight(), pos));
			}else if(tn.getVal() > word.charAt(pos)){
				tn.setLeft(insertInto(word, tn.getLeft(), pos));
			}else{
				if(pos+1 < word.length()){
					tn.setEq(insertInto(word, tn.getEq(), pos+1));
				}else{
					tn.setEnd(true);
				}
			}
			return tn;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}


class TernaryNode
{
	private char val;
	private boolean isEnd;
	private TernaryNode left;
	private TernaryNode right;
	private TernaryNode eq;
	
	public TernaryNode(char val,boolean isEnd,TernaryNode left,TernaryNode right,TernaryNode eq){
		this.val = val;
		this.isEnd = isEnd;
		this.left = left;
		this.right = right;
		this.eq = eq;
	}
	
	public void setEq(TernaryNode eq){
		this.eq = eq;
	}
	public void setLeft(TernaryNode left){
		this.left = left;
	}
	public void setRight(TernaryNode right){
		this.right = right;
	}
	public void setVal(char val){
		this.val = val;
	}
	public void setEnd(boolean isEnd){
		this.isEnd = isEnd;
	}
	public TernaryNode getEq(){
		return eq;
	}
	public char getVal(){
		return val;
	}
	public TernaryNode getLeft(){
		return left;
	}
	public TernaryNode getRight(){
		return right;
	}
	public boolean getEnd(){
		return isEnd;
	}
}