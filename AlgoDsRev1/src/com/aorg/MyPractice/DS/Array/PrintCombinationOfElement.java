package com.aorg.MyPractice.DS.Array;

public class PrintCombinationOfElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {1, 2, 3, 4,5};
			int r=3;
			new PrintCombinationOfElement().pritCom(a, r, 0,0,a.length-1,new int[3]);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private void pritCom(int[] a,int r,int ind,int st,int end,int[] data){
		try{
			if(ind == r){
				for(int i=0;i<r;i++){
					System.out.print(data[i]+",");
				}
				System.out.println();
				return;
			}
			for(int i = st;i<=end&&end-i+1>=r-ind;i++){
				data[ind] = a[i];
				pritCom(a, r, ind+1, i+1, end, data);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
