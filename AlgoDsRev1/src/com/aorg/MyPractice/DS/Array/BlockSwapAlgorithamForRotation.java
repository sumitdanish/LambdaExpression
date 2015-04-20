package com.aorg.MyPractice.DS.Array;

public class BlockSwapAlgorithamForRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			int[] a = {1, 2, 3, 4, 5, 6, 7};
			new BlockSwapAlgorithamForRotation().rotation(a,3);
			for(int a1 : a){
				System.out.print(a1+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	
	public void rotation(int[] a,int d){
		try{
			int  i =d;
			int p = d;
			int n = a.length;
			int j = n-p;
			while(i != j){
				if(i > j){
					swap(a,d - i,d, j);
					i = i-j;
				}else{
					swap(a,p-i,p+j-i, i);
					j = j-i;
				}
			}
			swap(a,d-i,d,i);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	/*This method will swap block of array i.e one block will start from
	 *  fi and other block will start from si
	*/
	private void swap(int[] a,int fi,int si,int d){
		int temp = 0;
		for(int i = 0;i<d;i++){
			temp = a[fi+i];
			a[fi+i] = a[si+i];
			a[si+i] = temp;
		}
	}
	
	
}
