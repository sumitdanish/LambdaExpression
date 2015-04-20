package com.aorg.MyPractice.DS.Array;

import java.util.HashMap;

public class SortArrayAccordingToPattern {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		try{
			SortArrayAccordingToPattern so = new SortArrayAccordingToPattern();
			int[] a = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
			int[] a1 = {2, 1, 8, 3};
			so.quickSort(a,0,a.length-1);
//			for(int a2:a){
//				//System.out.print(a2+",");
//			}
//			//System.out.println("\n");
			so.sort(a, a1);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private void sort(int[] a,int[] a1){
		try{
			boolean[] visited = new boolean[a.length];
			int k=0;
			int[] temp = new int[a.length];
			for(int i=0;i<a.length;i++){
				visited[i] = false;
			}
			for(int i=0;i<a.length;i++){
				temp[i] = a[i];
			}
			for(int i=0;i<a1.length;i++){
				int ind = binarySearch(temp,0,temp.length-1,a1[i]);
				for(int j=ind;j<temp.length;j++){
					if(temp[j]==a1[i]&&visited[j]==false){
						visited[j] = true;
						a[k] = temp[j];
						k++;
					}
				}
			}
			for(int i=0;i<temp.length;i++){
				if(visited[i]==false){
					a[k] = temp[i];
					k++;
				}
			}
			for(int i=0;i<temp.length;i++){
				System.out.print(a[i]+",");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private int binarySearch(int[] a,int left,int right,int key){
		try{
			int mid = (left+right)/2;
			if(a[mid]==key||key>a[mid-1]){
				return mid;
			}
			if(mid-1>left&&a[mid]>key){
				return binarySearch(a, left, mid-1, key);
			}else if(mid+1<right&&a[mid]<key){
				return binarySearch(a,mid+1, right, key);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
	private void quickSort(int a[],int l,int r){
		try{
			if(l<r){
				int p = partioned(a,l,r);
				quickSort(a, l,p-1);
				quickSort(a,p,r);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private int partioned(int[] a,int left,int right){
		try{
			int l = left;
			int r = right;
			int p = a[right];
			while(l<r){
				while(p>a[l]){
					l++;
				}
				while(p<a[r]){
					r--;
				}
				if(l<r){
					int temp = a[l];
					a[l] = a[r];
					a[r] = temp;
					l++;
					r--;
				}
			}
			return l;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	public void byMap(int[] a,int[] a1){
		try{
			int x=0;
			HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
			
			for(int i=0;i<a.length;i++){
				int count=1;
				if(map.containsKey(map.get(a[i]))){
					count++;
				}
				if(count>1){
					
				}
				map.put(a[i],count);
			}
			for(int i=0;i<a1.length;i++){
				int l = map.get(a1[i]);
				for(int j=0;j<l;j++){
					//System.out.print(a1[i]+",");
					x++;
				}
			}
			for(int a2:a){
				System.out.print(a2+",");
			}
			for(int x1=x;x1<a.length;x1++){
				//System.out.print(a[x1]+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
