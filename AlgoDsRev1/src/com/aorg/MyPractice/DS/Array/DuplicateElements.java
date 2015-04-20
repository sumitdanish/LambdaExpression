package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;

public class DuplicateElements {

	/**
	 * @param args
	 * {1, 2, 3, 4, 1, 2, 3, 4}
	 */
	public static void main(String[] args) {
		try{
			int[] a={1, 2,3, 4, 1, 2, 3, 4};
			DuplicateElements d = new DuplicateElements();
			boolean b = d.isDuplicate1(a,3);
			if(b){
				System.out.println("Its Duplicate in the given range");
			}else{
				System.out.println("No duplicate");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private boolean isDuplicate(int[] a,int k){
		try{
			for(int i=0;i<a.length-k;i++){
				for(int j=i+1;j<k+i;j++){
					if(a[i]==a[j]){
						return true;
					}
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	private boolean isDuplicate1(int[] a,int k){
		try{
			HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
			for(int i=0;i<a.length;i++){
				if(map.containsKey(a[i])){
					return true;
				}
				if(i>=k){
					map.remove(a[i-k]);
				}
				map.put(a[i],a[i]);
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
