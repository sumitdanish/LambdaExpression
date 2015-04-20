package com.aorg.MyPractice.DS.Array;

public class ClosestPair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			ClosestPair c = new ClosestPair();
			int[] a1 =  {1, 4, 5, 7};
			int[] a2 = {10, 20, 30, 40};
			c.closetPair(a1, a2,30);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private void closetPair(int[] a1,int[] a2,int x){
		try{
			int l = 0;
			int m=a2.length-1;
			int lIndex=0;
			int rIndex=0;
			int diff = Integer.MAX_VALUE;
			while(l<a1.length&&m>=0){
				if(diff>Math.abs(x-a1[l]-a2[m])){
					diff=Math.abs(x-a1[l]-a2[m]);
					lIndex = l;
					rIndex=m;
				}
				if((a1[l]<a2[m])&&(a1[l]+a2[m]<x)){
					l++;
				}else{
					m--;
				}
			}
			System.out.println(diff+" > "+a1[lIndex]+" > > "+a2[rIndex]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
