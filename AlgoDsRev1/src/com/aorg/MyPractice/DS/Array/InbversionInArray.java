package com.aorg.MyPractice.DS.Array;

public class InbversionInArray {

	/**
	 * @param args
	 */
	
	static int[] temp ;
	static int[] a;
	public static void main(String[] args) {
		try{
			a = new int[]{2,4,1,3,5};
			int inv = new InbversionInArray(5).mergeSort(0,4);
			System.out.println(inv);
			for(int a1 : a){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public InbversionInArray(int n){
		temp = new int[n];
	}
	
	public int mergeSort(int l,int r){
		try{
			int inv_count = 0;
			if(l < r){
				int m = (l+r)/2;
				inv_count = mergeSort(l,m);
				inv_count+=mergeSort(m+1, r);
				inv_count+=merge(l,m,r);
			}
			return inv_count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public int merge(int left,int mid,int right){
		try{
			int l = left;
			int r = right;
			int m = mid+1;
			int index = l;
			int inv_count = 0;
			for(int i = l;i<=right;i++){
				temp[i] = a[i];
			}
			while(l<=mid && m<=right){
				if(temp[l] <= temp[m]){
					a[index] = temp[l];
					l++;
				}
				else{
					a[index] = temp[m];
					inv_count+=(m-l);
					m++;
				}
				index++;
			}
			while(l <= mid){
				a[index] = temp[l];
				index++;
				l++;
			}
			while(m <= r){
				a[index] = temp[m];
				m++;
				index++;
			}
			return inv_count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
}
