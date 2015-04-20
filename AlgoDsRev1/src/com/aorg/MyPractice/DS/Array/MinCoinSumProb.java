package com.aorg.MyPractice.DS.Array;

public class MinCoinSumProb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] a = {1,2,3};
			int sum = 5;
			int[] minCoinA = new int[a.length];
			int[] solCoin = new int[a.length];
			//int minCoin = new MinCoinSumProb().getMinCoin(a, sum,a.length-1);
			int minCoin = new MinCoinSumProb().minCo(a,a.length,sum);
			System.out.println(minCoin);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private int minC(int[] a,int[] minCoin,int p,int len){
		try{
			
			if(p==0){
				return 0;
			}
			for(int i=0;i<len;i++){
				if(p>a[i]){
					minCoin[i] = minC(a, minCoin, p-a[i], len)+1;
				}
			}
			int fs = Integer.MAX_VALUE;
			for(int i=0;i<a.length;i++){
				if(fs>minCoin[i]){
					fs = minCoin[i];
				}
			}
			return fs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	/**Bottom up approach*/
	
	private int minCo(int[] a,int len,int p){
		try{
			int[] mc = new int[p+1];
			mc[0] = 0;
			int x = 0;
			for(int i=1;i<mc.length;i++){
				mc[i] = Integer.MAX_VALUE;
			}
			for(int j=1;j<=p;j++){
				for(int k = 0;k<a.length;k++){
					if(j>=a[k] && mc[j-a[k]]+1<mc[j]){
						mc[j] = mc[j-a[k]]+1;
					}
					x = mc[j];
				}
				System.out.println(x);
			}
			return mc[p];
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
		
	private int getMin(int a,int b){
		return a>b?b:a;
	}
}
