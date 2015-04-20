package com.aorg.MyPractice.DS.Array;

public class StableMarrigeProb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int N = 4;
			 int[][] prefer = { 
					 			{7, 5, 6, 4},
						        {5, 4, 6, 7},
						        {4, 5, 6, 7},
						        {4, 5, 6, 7},
						        {0, 1, 2, 3},
						        {0, 1, 2, 3},
						        {0, 1, 2, 3},
						        {0, 1, 2, 3},
				    		 };
			 new StableMarrigeProb().marrigeProb(prefer,N);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean isPrefernce(int[][] pre,int w,int m1,int m,int n){
		try{
			for(int i=0;i<n;i++){
				if(pre[w][i] == m){
					return true;
				}
				if(pre[w][i] == m1)
					return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private void marrigeProb(int[][] pre,int n){
		try{
			int freeCount = n;
			int[] woman = new int[n];
			boolean[] man = new boolean[n];
			for(int i=0;i<n;i++){
				woman[i] = -1;
				man[i] = false;
			}
			
			while(freeCount > 0){
				int m = 0;
				for(int i=0;i<n;i++){
					if(man[i] == false){
						m = i;
						break;
					}
				}
				for(int i=0;i<n&&!man[m];i++){
					int w = pre[m][i];
					if(woman[w-n] == -1){
						man[m] = true;
						woman[w-n] = m;
						freeCount--;
					}else{
						int m1 = woman[w-n];
						if(isPrefernce(pre, w, m1, m, n)){
							woman[w-n] = m;
							man[m] = true;
							man[m1] = false;
							freeCount--;
						}
					}
				}
			}
			
			for(int i=0;i<n;i++){
				System.out.println(i+n+" > "+woman[i]);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
