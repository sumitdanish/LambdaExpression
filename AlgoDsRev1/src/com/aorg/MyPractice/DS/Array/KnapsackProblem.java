package com.aorg.MyPractice.DS.Array;

public class KnapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] b = {3,4,5,6};
			int[] we = {2,3,4,5};
			int w = 5;
			new KnapsackProblem().knapsackProb(we, b, w);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void knapsackProb(int[] we,int[] b,int w/*Max wight*/){
		try{
			int[][] v = new int[we.length+1][w+1];
			for(int i = 0;i<=we.length;i++){
				v[i][0] = 0;
			}
			for(int j = 0;j<=w;j++){
				v[0][j] = 0;
			}
			
			for(int i = 1;i<=we.length;i++){
				for(int w1 = 1 ; w1<=w;w1++ ){
					if(we[i-1] <= w1){
						v[i][w1] = max((b[i-1]+v[i-1][w1-we[i-1]]),v[i-1][w1]);
					}else{
						v[i][w1] = v[i-1][w1];
					}
				}
			}
			for(int i = 0;i<=we.length;i++){
				for(int j = 0;j<=w;j++){
					System.out.print(v[i][j]+",");
				}
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private int max(int a,int b){
		try{
			return a > b ? a : b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
