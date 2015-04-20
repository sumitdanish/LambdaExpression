package com.aorg.MyPractice.DS.Array;

public class CuttingARod {

	/**
	 * @param args
	 */
	static int[] s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] p = { 3,5,8,9,10,17,17,20};
			 new CuttingARod().getMaxx(p,p.length);
			 
			//System.out.println(max_val);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/*Overlapping subproblem*/
	private int getMaxProfit(int[] price,int n){
		try{
			if(n==0){
				return 0;
			}
			int max_val = Integer.MIN_VALUE;
			for(int i=0;i<n;i++){
				max_val = getMax(max_val,(price[i]+getMaxProfit(price, n-i-1)));
			}
			return max_val;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMax(int a,int b){
		try{
			return a > b ? a : b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
	private void getMaxx(int[] price,int n){
		try{
			int[] r = new int[price.length+1];
			r[0] =0;
			s = new int[price.length+1];
			for(int i=1;i<=price.length;i++){
				int max = Integer.MIN_VALUE;
				for(int j=0;j<i;j++){
					if(max<(price[j]+r[i-j-1])){
						max = (price[j]+r[i-j-1]);
						s[i] = j;
						System.out.print(i+",");
					}
				}
				r[i] = max;
			}
			
			System.out.println("\n"+r[n]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private int getMaxProfit1(int[] price,int n,int[] r){
		try{
			if(r[n]>=0){
				return r[n];
			}
			int max_val = Integer.MIN_VALUE;
			if(n==0){
				max_val = 0;
			}else{
				max_val = Integer.MIN_VALUE;
			}
			for(int i=0;i<price.length;i++){
				max_val = getMax(max_val,(price[i]+getMaxProfit1(price, n-i-1, r)));
				r[n] = max_val;
			}
			
			return max_val;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMaxProfit11(int[] price){
		try{
			int[] r = new int[price.length+1];
			for(int i=0;i<=price.length;i++){
				r[i] = -1;
			}
			int max_profit = getMaxProfit1(price,price.length, r);
			return max_profit;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
