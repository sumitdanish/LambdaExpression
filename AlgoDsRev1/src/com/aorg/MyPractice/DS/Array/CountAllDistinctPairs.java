package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;

public class CountAllDistinctPairs {

	/**
	 * @param args
	 */
	static int[] array;
	static int[] temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] a = {1, 5, 3, 4, 2};
			int key = 3;
			CountAllDistinctPairs count = new CountAllDistinctPairs();
			count.mergerSort(0,array.length-1);
			int c = count.countOccurence(key);
			System.out.println(c);
//			for(int a1 : array){
//				System.out.print(a1+",");
//			}
			//int count = new CountAllDistinctPairs().byMap(a, key);
			//System.out.println(count);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public CountAllDistinctPairs(){
		temp = new int[5];
		array =new int[]{1, 5, 3, 4, 2};
	}
	
	private int byMap(int[] a,int key){
		try{
			int count = 0;
			HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
			for(int i=0;i<a.length;i++){
				map.put(a[i],a[i]);
			}
			for(int i=0;i<a.length;i++){
				if(map.containsKey(key+a[i])){
					count++;
				}
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
	private int countOccurence(int key){
		try{
			int count = 0;
			int i = 0;
			int j=0;
			while(i<array.length-1&&j<array.length-1){
				if(array[i]+key == array[j]){
					count++;
					j++;i++;;
				}
				if(array[j]-array[i]>key){
					i++;
				}else{
					j++;
				}
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private void mergerSort(int left,int right){
		if(left<right){
			int mid = (left+right)/2;
			mergerSort(left,mid);
			mergerSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	private void merge(int left,int mid,int right){
		try{
			int l = left;
			int r = right;
			int m = mid+1;
			int tempIndex = left;
			for(int i=left;i<=right;i++){
				temp[i] = array[i];
			}
			while(l<=mid&&m<=right){
				if(temp[l]<temp[m]){
					array[tempIndex] = temp[l];
					l++;tempIndex++;
				}
				if(temp[m]<temp[l]){
					array[tempIndex] = temp[m];
					m++;tempIndex++;
				}
			}
			while(l<=mid){
				array[tempIndex] = temp[l];
				l++;tempIndex++;
			}
			while(m<=right){
				array[tempIndex] = temp[m];
				m++;tempIndex++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
