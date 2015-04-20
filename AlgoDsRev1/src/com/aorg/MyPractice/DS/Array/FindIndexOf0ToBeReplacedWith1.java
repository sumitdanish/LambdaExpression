package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;

public class FindIndexOf0ToBeReplacedWith1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			FindIndexOf0ToBeReplacedWith1 f = new FindIndexOf0ToBeReplacedWith1();
			
			int[] a = {1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1};
			f.findIndexOfZero(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void findIndexOfZero(int[] a){
		try{
			HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
			int count0s = 0;
			int count1s = 1;
			int index = 0;
			int index1 = 0;
			int max=Integer.MIN_VALUE;
			for(int i=0;i<a.length;i++){
				if(a[i]==1){
					count0s=0;
					if(count0s==0){
						if(map.containsKey(1)){
							count1s++;
						}
						map.put(1,count1s);
						if(max<map.get(1)){
							max=map.get(1);
							index1=index;
						}
					}
					
				}else{
					if(count0s==0){
						index=i;
					}
					count0s++;
					if(count0s>1){
						while(!map.isEmpty()){
							map.remove(1);
						}
						count1s=0;
						count0s=0;
					}
				}
			}
			System.out.println(index1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
