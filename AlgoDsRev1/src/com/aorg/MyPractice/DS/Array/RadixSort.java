package com.aorg.MyPractice.DS.Array;

import java.util.ArrayList;
import java.util.LinkedList;

public class RadixSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] a = {170, 045, 075, 90, 002, 024, 802, 066};
			new RadixSort().radixSort(a) ;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private void radixSort(int[] a){
		try{
			int base=10;
			int exp = 1;
			int[] ar = new int[10];
			int[] bucket = new int[10];
			LinkedList<Integer>[] arrayList = new LinkedList[10];
			for(int i=0;i<10;i++){
				arrayList[i] = new LinkedList<Integer>();
			}
			for(int i=0;i<a.length;i++,exp*=10,base*=10){
				for(int j=0;j<a.length;j++){
					int c = (a[j]%base)/exp;
					System.out.print(c+",");
					//arrayList[c].add(a[j]);
				}
				//System.out.println("\n---");
				int pos = 0;
				for(int k = 0;k<a.length ; k++){
					Integer val = 0;
					while((val=arrayList[k].poll())!=null){
						ar[pos++] = val;
					}
				}
			}
			for(int i=0;i<ar.length;i++){
				System.out.print(ar[i]+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
