package com.aorg.MyPractice.DS.Array;

public class LCS {

	/**
	 * @param args
	 */
	static int maxLen = 0;
	public static void main(String[] args) {
		try{
			int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80};
			int len = new LCS().getLCS1(a);
			System.out.println(len);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public int getLCS(int[] a,int n){
		try{
			if(n == 1){
				return 1;
			}
			int res = 0;
			int max = 1;
			for(int i = 1; i < n;i++){
				res = getLCS(a,i);
				if(a[n-1] > a[i-1] && res+1 > max){
					max = res+1;
				}
			}
			if(maxLen < max){
				maxLen = max;
			}
			return max;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public int getLCS1(int[] a){
		try{
			int[] lcs = new int[a.length+1];
			for(int i = 0;i<a.length;i++){
				lcs[i] = 1;
			}
			for(int i = 1;i<a.length;i++){
				for(int j = 0;j < i;j++){
					if(a[j] < a[i]){
						lcs[i] = getMax(lcs[i],lcs[j]+1);
					}
				}
			}
			int max = -1;
			for(int i = 0;i<lcs.length;i++){
				if(max  < lcs[i]){
					max = lcs[i];
				}
			}
			return max;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMax(int a,int b){
		return a > b ? a : b;
	}
}
