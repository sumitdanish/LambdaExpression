package com.aorg.MyPractice.DS.Array;

public class FindDuplicateInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {1, 2, 3, 1, 3, 6, 6};
			new FindDuplicateInAnArray().duplicate(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void duplicate(int[] a){
		try{
			for(int i = 0;i<a.length;i++){
				if(a[Math.abs(a[i])] >=0){
					a[Math.abs(a[i])] = -a[Math.abs(a[i])];
				}else{
					System.out.println("Du > "+Math.abs(a[i]));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
