package com.aorg.MyPractice.DS.StringAlgo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

public class TrieImpl {

	static TrieNode root;
	public static void main(String[] args){
		try{
			Date d1= new Date();
			long t1 = d1.getTime();
			System.out.println("Starting time > "+t1);
			TrieImpl dict = new TrieImpl();
			Scanner sc = new Scanner(new File("dict1.txt"));
			while(sc.hasNext()){
				dict.insert(sc.next().toString());
			}
			boolean b = dict.searchEngine("baqwerse");
			Date d2 = new Date();
			long t2 = d2.getTime();
			if(b){
				System.out.println("Found");
				System.out.println("Ending time > "+t2);
			}else{
				System.out.println("Not found");
			}
			System.out.println("Total time taken > "+(t2-t1));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	
	public TrieImpl(){
		root = new TrieNode((char)0);
	}
	public void insert(String word){
		try{
			TrieNode trie = root;
			for(int i=0;i<word.length();i++){
				HashMap<Character,TrieNode> tr = trie.getTriNode();
				char ch = word.charAt(i);
				if(tr.containsKey(ch)){
					trie = tr.get(ch);
				}else{
					TrieNode trieNode = new TrieNode(ch);
					tr.put(ch,trieNode);
					trie = trieNode;
				}
			}
			trie.setIsEnd(true);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public boolean searchEngine(String word){
		try{
			TrieNode trie = root;
			StringBuilder sb = new StringBuilder();
			int len = 0;
			for(int i = 0;i<word.length();i++){
				HashMap<Character, TrieNode> map = trie.getTriNode();
				char ch = word.charAt(i);
				if(map.containsKey(ch)){
					trie = map.get(ch);
					sb = sb.append(ch);
					len++;
				}
			}
			if(trie.isEnd() && len == word.length()){
				System.out.println(sb);
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
}

class TrieNode
{
	private char val;
	private boolean isEnd;
	HashMap<Character,TrieNode> triNode = new HashMap<Character, TrieNode>();
	ArrayList<String> st = new ArrayList<String>();
	public TrieNode(char val){
		this.val = val;
		this.isEnd = false;
		this.triNode = new HashMap<Character, TrieNode>();
	}
	
	public void setTriNode(HashMap<Character,TrieNode> triNode){
		this.triNode = triNode;
	}
	public void setIsEnd(boolean isEnd){
		this.isEnd = isEnd;
	}
	public void setVal(char val){
		this.val = val;
	}
	
	public boolean isEnd(){
		return isEnd;
	}
	public HashMap<Character,TrieNode> getTriNode(){
		return triNode;
	}
	public char getVal(){
		return val;
	}
	
}
