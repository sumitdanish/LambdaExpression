package com.aorg.MyPractice.DS.Array;

public class NumberOfInversion {

	/**
	 * @param args
	 */
	static int inv=0;
	static int[] temp;
	
	static int[] a;
	public static void main(String[] args) {
		try{
			NumberOfInversion n = new NumberOfInversion();
			a = new int[] { 1, 20, 6, 4, 5 };
			temp = new int[a.length];
			int count = n.merge(0,a.length-1) ;
			System.out.println(count);
			for(int k : a){
				System.out.print(k+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int merge(int left,int right){
		try{
			if(left<right){
				int mid = (left+right)/2;
				inv=merge(left,mid);
				inv+=merge(mid+1,right);
				inv+=mergeSort(left,mid,right);
			}
			return inv;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int mergeSort(int left,int mid,int right){
		try{
			for(int l = left;l<=right;l++){
				temp[l] = a[l];
			}
			int i = left;
			int j=right;
			int m = mid+1;
			int tempIndex=i;
			while(i<=mid&&m<=right){
				if(temp[i]<=temp[m]){
					a[tempIndex] = temp[i];
					i++;
				}else{
					a[tempIndex] = temp[m];
					m++;
					inv += (mid-i);
				}
				tempIndex++;
			}
			while(i<=mid){
				a[tempIndex] = temp[i];
				i++;
				tempIndex++;
			}
			while(m<=right){
				a[tempIndex] = temp[m];
				m++;
				tempIndex++;
			}
			return inv;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return -1;
	}
}
