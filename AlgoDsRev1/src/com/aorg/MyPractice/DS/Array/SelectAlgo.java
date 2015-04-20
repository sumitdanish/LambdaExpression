package com.aorg.MyPractice.DS.Array;

public class SelectAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {1,3,7,4,9,2,5,6};
			int kth = new SelectAlgo().getKthElement(a,0,a.length-1,2);
			System.out.println(kth);
//			new SelectAlgo().quickSort(0,a.length-1, a);
//			for(int a1 : a){
//				System.out.print(a1+",");
//			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void quickSort(int left,int right,int[] a){
		try{
			if(left < right){
				int p = pivot(left, right, a);
				quickSort(left,p-1, a);
				quickSort(p+1, right, a);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private int pivot(int left,int right,int[] a){
		try{
			int i = left;
			int key = a[left];
			for(int j = left+1;j<=right;j++){
				if(key >= a[j]){
					i++;
					int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
				}
			}
			int temp = a[i];
			a[i] = a[left];
			a[left] = temp;
			return i;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getKthElement(int[] a,int left,int right,int index){
		try{
			int r = pivot(left, right, a);
			/*Rank of element is the position in the sorted array*/
			int k = r - left+1; // Rank of the element i.e 
			if(k == index){
				return a[r];
			}if(k > index){
				return getKthElement(a, left,r-1, index);
			}
			return getKthElement(a,r+1, right, index-k);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
