package com.aorg.MyPractice.DS.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SuffixTreePart1 {

	
	public static void main(String[] args){
		try{
			ArrayList<Suffix> suffixList = new ArrayList<Suffix>();
			String str = "banana";
			SuffixTreePart1 suffixImpl = new SuffixTreePart1();
			suffixList = suffixImpl.suffixList(str);
			int ind = suffixImpl.binarySearch(0,suffixList.size(), suffixList,"nana");
			System.out.println(ind);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private ArrayList<Suffix> suffixList(String str){
		try{
			ArrayList<Suffix> suffixList = new ArrayList<Suffix>();
			for(int i=0;i<str.length();i++){
				String st = str.substring(i,str.length());
				Suffix su = new Suffix(i,st);
				suffixList.add(su);
			}
			Collections.sort(suffixList,new SortSuffix());
			return suffixList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private int binarySearch(int left,int right,ArrayList<Suffix> suffixList,String key){
		try{
			int mid = (left+right)/2;
			int com = key.compareTo(suffixList.get(mid).getSuffix());
			if(com==0){
				return suffixList.get(mid).getIndex();
			}
			if(com<0){
				return binarySearch(left, mid-1, suffixList, key);
			}
			return binarySearch(mid+1, right, suffixList, key);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
class Suffix
{
	private int index;
	private String suffix;
	public Suffix(int index,String suffix){
		this.index = index;
		this.suffix = suffix;
	}
	public void setIndex(int index){
		this.index = index;
	}
	public void setSuffix(String suffix){
		this.suffix  =suffix;
	}
	
	public int getIndex(){
		return index;
	}
	public String getSuffix(){
		return suffix;
	}
}

class SortSuffix implements Comparator<Suffix>
{

	@Override
	public int compare(Suffix o1, Suffix o2) {
		return o1.getSuffix().compareTo(o2.getSuffix());
	}
}