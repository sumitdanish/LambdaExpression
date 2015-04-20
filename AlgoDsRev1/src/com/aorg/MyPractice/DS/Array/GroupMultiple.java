package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class GroupMultiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {5, 3, 5, 1, 3, 3};
			new GroupMultiple().bruteForce(a);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void bruteForce(int[] a){
		try{
			boolean[] visited = new boolean[a.length];
			for(int i = 0;i < a.length ; i++){
				if(!visited[i]){
					System.out.print(a[i]+",");
					for(int j = i+1 ; j< a.length ; j++){
						if(a[i] == a[j]){
							System.out.print(a[i]+",");
							visited[j] = true;
						}
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private void groupElement(int[] a){
		try{
			HashMap<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
			int count = 0;
			for(int i = 0;i < a.length ; i++){
				count = 1;
				if(map.containsKey(a[i])){
					count+=map.get(a[i]);
				}
				map.put(a[i],count);
			}
			for(int i = 0; i <a.length ; i++){
				int cun = map.get(a[i]) != null ? map.get(a[i]) : 0;
				if(cun != 0){
					for(int  j = 0 ; j<cun;j++){
						System.out.print(a[i]+",");
					}
					map.remove(a[i]);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
