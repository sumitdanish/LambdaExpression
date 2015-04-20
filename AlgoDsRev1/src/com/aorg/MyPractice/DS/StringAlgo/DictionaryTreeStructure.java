package com.aorg.MyPractice.DS.StringAlgo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTreeStructure {

	/**
	 * @param args
	 */
	static TrieImplDict root;
	public static void main(String[] args) {
		try{
			DictionaryTreeStructure dict = new DictionaryTreeStructure();
			Scanner sc = new Scanner(new File("dictgen.txt"));
			while(sc.hasNext()){
				dict.createDictionary(sc.next().toString());
			}
			String s = dict.searchWord("IMQHITF");
			System.out.println(s);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public DictionaryTreeStructure(){
		root = new TrieImplDict((char)0);
	}
	
	
	public String searchWord(String word){
		try{
			TrieImplDict trie = root;
			StringBuilder sb = new StringBuilder();
			int len = 0;
			for(int i=0;i<word.length();i++){
				char ch = word.charAt(i);
				HashMap<Character,TrieImplDict> dict = trie.getChild();
				if(dict.containsKey(ch)){
					trie = dict.get(ch);
					sb = sb.append(ch);
					len++;
				}else{
					break;
				}
			}
			StringBuilder query = new StringBuilder();
			if(trie.isEnd() == true && len == word.length()){
				if(trie.getWordList() != null){
					for(String ar : trie.getWordList()){
						query = query.append(ar).append(",");
					}
				}else{
					query.append("NO Word");
				}
			}else{
				query.append("Entered Word is not matching");
			}
			return sb.append(" : ").append(query).toString();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void createDictionary(String word){
		try{
			String[] splitWord = word.split("");
			String[] meaning = splitWord[0].split(",");
			String spell = splitWord[0];
			TrieImplDict trie = root;
			ArrayList<String>  list;
			for(int i=0;i<spell.length();i++){
				HashMap<Character,TrieImplDict> tr = trie.getChild();
				if(tr.containsKey(word.charAt(i))){
					trie = tr.get(word.charAt(i));
				}else{
					TrieImplDict node = new TrieImplDict(word.charAt(i));
					tr.put(word.charAt(i),node);
					trie = node;
				}
			}
			if(trie.getWordList() == null){
				list = new ArrayList<String>();
			}else{
				list = trie.getWordList();
			}
			if(meaning.length > 1){
				for(String w : meaning){
					list.add(w);
				}
			}else{
				list.add(splitWord[1]);
			}
			trie.setIsEnd(true);
			trie.setWordList(list);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
class TrieImplDict
{
	private char val;
	private boolean isEnd;
	private HashMap<Character,TrieImplDict>  child;
	private ArrayList<String> wordList;
	public TrieImplDict(char val){
		this.val = val;
		child = new HashMap<Character, TrieImplDict>();
		this.isEnd = false;
	}
	
	public void setChild(HashMap<Character,TrieImplDict> child){
		this.child = child;
	}
	
	public void setVal(char val){
		this.val = val;
	}
	public void setIsEnd(boolean isEnd){
		this.isEnd  = isEnd;
	}
	
	public boolean isEnd(){
		return isEnd;
	}
	public void setWordList(ArrayList<String> wordList){
		this.wordList = wordList;
	}
	public ArrayList<String> getWordList(){
		return wordList;
	}
	public char getVal(){
		return val;
	}
	public HashMap<Character,TrieImplDict> getChild(){
		return child;
	}
	
	
}