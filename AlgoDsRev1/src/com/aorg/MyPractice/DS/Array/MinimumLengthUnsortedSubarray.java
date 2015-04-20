package com.aorg.MyPractice.DS.Array;

public class MinimumLengthUnsortedSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
			new MinimumLengthUnsortedSubarray().subArraySorted(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void subArraySorted(int[] a){
		try{
			int st = 0;
			int en = 0;
			
			for(int i = 1; i <a.length ; i++){
				if(a[i] < a[i-1]){
					st = i-1;
					break;
				}
			}
			for(en = a.length-1; en>=0;en--){
				if(a[en] < a[en-1]){
					break;
				}
			}
			int min = a[st];
			int max = a[st];
			for(int i = st; i <=en ; i++){
				if(min > a[i]){
					min = a[i];
				}
				if(max < a[i]){
					max = a[i];
				}
			}
			System.out.println(min+","+max);
			for(int i = 0;i<=st;i++){
				if(min < a[i]){
					st = i;
					break;
				}
			}
			for(int i = a.length-1;i>=en;i--){
				if(max > a[i]){
					en = i;
					break;
				}
			}
			System.out.println(st+" > "+en);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
