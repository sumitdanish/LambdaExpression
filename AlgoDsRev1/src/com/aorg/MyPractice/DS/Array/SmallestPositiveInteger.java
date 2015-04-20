package com.aorg.MyPractice.DS.Array;

public class SmallestPositiveInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			SmallestPositiveInteger sm = new SmallestPositiveInteger();
			int[] a={1, 1, 1, 1};
			int val = sm.getSmallest(a);
			System.out.println(val);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private int getSmallest(int[] a){
		try{
			int res=1;
			for(int i = 0;i<a.length;i++){
				if(a[i]<=res){
					res+=a[i];
				}
			}
			return res;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
