package com.aorg.MyPractice.DS.Array;

public class MaximumSumPathinTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			 MaximumSumPathinTwoArrays max = new MaximumSumPathinTwoArrays();
			 int[] a1 = {2, 3, 7, 10, 12, 15, 30, 34};
		     int[] a2 = {1, 5, 7, 8, 10, 15, 16, 19};
		     int res = max.maxSum(a1, a2);
		     System.out.println(res);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int maxSum(int[] a1,int[] a2){
		try{
			int i=0;
			int j=0;
			int sum1=0;
			int sum2=0;
			int result = 0;
			while(i<a1.length&&j<a2.length){
				if(a1[i]<a2[j]){
					sum1+=a1[i];
					i++;
				}else if(a1[i]>a2[j]){
					sum2+=a2[j];
					j++;
				}else{
					result+=getMax(sum1,sum2);
					sum1=0;
					sum2=0;
					while(i<a1.length&&j<a2.length&&a1[i]==a2[j]){
						result+=a1[i];
						i++;j++;
					}
				}
			}
			sum1 = 0;sum2=0;
			while(i<a1.length){
				sum1+=a1[i];
				i++;
			}
			while(j<a2.length){
				sum2+=a2[j];
				j++;
			}
			result+=getMax(sum1,sum2);
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMax(int a,int b){
		try{
			return a>b?a:b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}
