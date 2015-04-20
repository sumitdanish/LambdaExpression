package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;

public class LargestComonSubsequence {

	/**
	 * @param args
	 * Largest common subsequence : if diffrence between max and min in subarray is same as the 
	 * diiffrence between last index and first index;
	 * 
	 */
	public static void main(String[] args) {
		try{
			LargestComonSubsequence l = new LargestComonSubsequence();
			int[] a = {10, 12, 11};
			int len = l.getCount(a);
			System.out.println(len);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getLCS(int[] a){
		try{
			int count=0;
			HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
			for(int i=0;i<a.length;i++){
				map.put(a[i],1);
			}
			int max=0;
			for(int i=0;i<a.length;i++){
				count = getCountKey(map,a[i]);
				if(count>max){
					max=count;
				}
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getCountKey(HashMap<Integer,Integer> map,int key){
		try{
			int count=0;
			if(map.get(key)>1||map.get(key+1)==null){
				return map.get(key);
			}
			count = map.get(key);
			map.put(key,(count+map.get(key+1)));
			return map.get(key);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int getCount(int[] a){
		try{
			int max=Integer.MIN_VALUE;
			int min=Integer.MAX_VALUE;
			int count = Integer.MIN_VALUE;
			for(int i=0;i<a.length;i++){
				max=a[i];min=a[i];
				for(int j=i+1;j<a.length-1;j++){
					max=getMax(max,a[j]);
					min=getMin(min,a[j]);
					if((max-min)==j-i+1){
						count = getMax(count,(j-i+1));
					}
				}
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMin(int a,int b){
		try{
			return a>b?b:a;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int getMax(int a,int b){
		try{
			return a>b?a:b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	 

	
}
