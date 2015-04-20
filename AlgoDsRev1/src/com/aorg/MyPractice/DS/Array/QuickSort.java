package com.aorg.MyPractice.DS.Array;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = { 3, 7, 8, 5, 2, 1, 9, 5, 4 };//Consider its set of nuts
			int[] b = { 4, 2, 9, 5, 7, 1, 8, 5, 3 };// consider its set of bolt
			QuickSort q = new QuickSort();
			q.quickSort(a,0,a.length-1,b);
			for(int a1:a){
				System.out.print(a1+",");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void quickSort(int[] a,int l,int r,int[] b){
		try{
			if(l<r){
				int p = partion(a,l,r,b[r]);
				partion(b, l, r,a[p]);
				quickSort(a, l,p-1,b);
				quickSort(a,p+1,r,b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private int partion(int[] a,int l,int r,int p){
		try{
//			int p = a[r];
			int i=l;
			int j=r;
			while(i<j){
				while(p>a[i]){
					i++;
				}
				while(p<a[j]){
					j--;
				}
				if(i<j){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
			}
			return i;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
