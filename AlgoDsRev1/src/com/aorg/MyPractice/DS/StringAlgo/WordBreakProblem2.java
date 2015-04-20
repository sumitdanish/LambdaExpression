package com.aorg.MyPractice.DS.StringAlgo;
import java.util.*;
public class WordBreakProblem2 {

	/**
	 * @param args
	 * "cat", "cats", "and", "sand", "dog"
	 */
	public static void main(String[] args) {
		try{
			String str = "catsanddog";
			WordBreakProblem2 wordBreak = new WordBreakProblem2();
			HashSet<String> set = new HashSet<String>();
			set.add("cat");
			set.add("cats");
			set.add("and");
			set.add("sand");
			set.add("dog");
			wordBreak.createList(str, set);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void createList(String s,HashSet<String> set) {
		try{
			CreateWordList wordList = new CreateWordList(s.length());
			WordList[] wl = wordList.getWordList();
			int start = 0;
			for(int i = 0;i < s.length();i++){
				for(String str : set){
					start = i;
					int end = i+str.length();
					if(end > s.length()){
						continue;
					}
					String sub = s.substring(start,end);
					if(sub.equals(str)){
						System.out.println(" > "+str);
						if(wl[end-1] == null){
							wl[end-1] = new WordList();
						}
						wl[end-1] = wl[end-1].createWordList(str,wl[end-1]);
					}
				}
			}
			ArrayList<String> result = new ArrayList<String>();
			ArrayList<String> temp = new ArrayList<String>();
			dfs(temp, result, wl,s.length());
			for(WordList w : wl){
				if(w != null){
					w.printList(w);
				}
			}
			for(String r : result){
				System.out.println(r);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void dfs(ArrayList<String> temp,ArrayList<String> result,WordList[] wl,int end){
		try{
			if(end<=0){
				String path = temp.get(temp.size()-1);
				for(int i = temp.size()-2; i >=0;i--){
					path+=""+temp.get(i);
				}
				result.add(path);
				return;
			}
			for(WordList w : wl){
				temp.add(w.getVal() == null ? "":w.getVal());
				dfs(temp, result, wl, end-temp.size());
				temp.remove(w.getVal());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
class CreateWordList
{
	private WordList[] wordList;
	public CreateWordList(int len){
		wordList = new WordList[len];
		for(int i = 0;i<len;i++){
			wordList[i] = new WordList();
		}
	}
	public WordList[] getWordList(){
		return wordList;
	}
	
	
}
class WordList
{
	private String val;
	private WordList next;
	public WordList(){
		
	}
	public WordList(String val){
		this.val = val;
	}
	public void setVal(String val){
		this.val = val;
	}
	public String getVal(){
		return val;
	}
	public void setNext(WordList next){
		this.next = next;
	}
	public WordList getNext(){
		return next;
	}
	public WordList createWordList(String val,WordList list){
		try{
			WordList word = new WordList(val);
			if(list == null){
				list = word;
				return list;
			}
			list.setNext(createWordList(val,list.getNext()));
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void printList(WordList list){
		try{
			WordList li = list;
			while(li != null){
					System.out.print(li.getVal()==null?"":li.getVal()+",");
				li = li.getNext();
			}
			System.out.println();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}