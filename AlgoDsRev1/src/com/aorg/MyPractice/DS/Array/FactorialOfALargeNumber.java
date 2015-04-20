package com.aorg.MyPractice.DS.Array;

public class FactorialOfALargeNumber {

	/**
	 * @param args
	 */
	static int MAX=500;
	public static void main(String[] args) {
		
		try{
			int n=85;
			FactorialOfALargeNumber fac = new  FactorialOfALargeNumber();
			fac.fact(n);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private void fact(int n){
		try{
			int[] res = new int[MAX];
			res[0]=1;
			int res_size=1;
			for(int x=2;x<=n;x++){
				res_size = multiply(res, res_size, x);
			}
			for(int j=res_size-1;j>=0;j--){
				System.out.print(res[j]);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private int multiply(int[] res,int res_size,int x){
		try{
			int carry = 0;
			for(int i=0;i<res_size;i++){
				int prod = res[i]*x+carry;
				res[i] = prod%10;
				carry=prod/10;
			}
			while(carry!=0){
				res[res_size]=carry%10;
				carry=carry/10;
				res_size++;
			}
			return res_size;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
