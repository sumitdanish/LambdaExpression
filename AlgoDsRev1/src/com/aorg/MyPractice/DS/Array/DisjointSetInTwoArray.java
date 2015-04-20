package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;

public class DisjointSetInTwoArray {

	/**
	 * @param args
	 */
	static int[] a1 = {12, 34, 11, 9, 3};
	static int[] a2 = {7, 2, 1, 5};
	public static void main(String[] args) {
		try{
			
			DisjointSetInTwoArray dis = new DisjointSetInTwoArray();
			dis.quickSort(a1,0,a1.length-1);
			dis.quickSort(a2,0,a2.length-1);
			boolean b = dis.byMergeSort(a1, a2);
//			boolean b = dis.isDisjoint(a1, a2);
			if(b){
				System.out.println("No Disjoint between the array");
			}else{
				System.out.println("Disjoint set in the array");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean isDisjoint(int[] a1,int[] a2){
		try{
			HashMap<Integer,Integer>  map = new HashMap<Integer, Integer>();
			for(int i=0;i<a1.length;i++){
				map.put(a1[i],a1[i]);
			}
			for(int i=0;i<a2.length;i++){
				if(map.containsKey(a2[i])){
					return true;
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean byMergeSort(int[] a1,int[] a2){
		try{
			int l = 0;
			int m = 0;
			System.out.println(l);
			System.out.println(m);
			while(l<a1.length-1||m<a2.length-1){
				if(a1[l]==a2[m]){
					return true;
				}
				if(a1[l]<a2[m]){
					l++;
				}else if(a1[l]>a2[m]){
					m++;
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private void quickSort(int[] a,int left,int right){
		try{
			int l = left;
			int r = right;
			int p = a[l];
			while(l<=r){
				while(p>a[l]){
					l++;
				}
				while(p<a[r]){
					r--;
				}
				if(l<=r){
					int temp = a[l];
					a[l] = a[r];
					a[r] = temp;
					l++;
					r--;
				}
				if(l<right){
					quickSort(a,l, right);
				}
				if(r>left){
					quickSort(a,left,r);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
