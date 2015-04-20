package com.aorg.MyPractice.DS.Array;

public class PrintMissingElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {88, 105, 3, 2, 200, 0, 10};
		
			new PrintMissingElements().printMissingElement(a,100);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	private void printMissingElement(int[] a,int len){
		try{
			boolean[] b = new boolean[len];
			for(int  i=0 ; i<a.length;i++){
				if(a[i] < len){
					b[a[i]] = true;
				}
			}
			for(int i = 0;i<len;i++){
				if(b[i] == false){
					int j = i+1;
					while(j < len && b[j] == false){
						j++;
					}
					if(j == i+1){
						System.out.println(i);
					}else{
						System.out.println(i+"-"+(j-1));
					}
					i = j;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
