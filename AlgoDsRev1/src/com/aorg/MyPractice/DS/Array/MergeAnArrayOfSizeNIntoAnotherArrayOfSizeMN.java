package com.aorg.MyPractice.DS.Array;

public class MergeAnArrayOfSizeNIntoAnotherArrayOfSizeMN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {2, 8, 0, 0, 0, 13, 0, 15, 20};
			int[] b = {5, 7, 9, 25};
			new MergeAnArrayOfSizeNIntoAnotherArrayOfSizeMN().merge(a, b);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void merge(int[] a,int[] b){
		try{
			a = putInToEnd(a);
			int i=0;
			int k=0;
			int j=a.length-1;
			int m = b.length;
			int n = a.length - b.length;
			int x = b.length;
			while(i < (m+n)){
				if((x < (m+n))&&(a[x] < b[k]) && k<b.length){
					a[i] = a[x];
					x++;i++;
				}else if(k<b.length){
					a[i] = b[k];
					k++;i++;
				}
			}
			for(int s : a){
				System.out.print(s+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int[] putInToEnd(int[] a){
		try{
			int k= a.length-1;
			for(int i = a.length -1 ;i >= 0 ; i--){
				if(a[i] != 0){
					a[k] = a[i];
					k--;
				}
			}
			while(k>=0){
				a[k] = 0;
				k--;
			}
			return a;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
