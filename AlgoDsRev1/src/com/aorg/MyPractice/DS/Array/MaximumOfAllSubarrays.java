package com.aorg.MyPractice.DS.Array;
import java.util.*;
public class MaximumOfAllSubarrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {1, 2, 3, 1, 4, 5, 2, 3, 6};
			int k = 3;
			new MaximumOfAllSubarrays().maximumOfSizeK(a, k);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void maximumOfSizeK(int[] a,int k){
		try{
			Queue<Integer> q = new LinkedList<Integer>();
			int i = 0;
			for(i = 0;i<k;i++){
				while(!q.isEmpty() && a[i] >= a[q.peek()]){
					q.poll();
				}
				q.add(i);
			}
			System.out.println(q.size()+"\n");
			for(;i<a.length;i++){
				System.out.print(a[q.peek()]+",");
				while(!q.isEmpty() && q.peek()<=i-k){
					q.poll();
				}
				while(!q.isEmpty() && a[q.peek()] <= a[i]){
					q.poll();
				}
				q.add(i);
			}
			System.out.print(a[q.peek()]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
