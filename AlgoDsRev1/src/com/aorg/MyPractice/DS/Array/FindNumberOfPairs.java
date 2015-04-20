package com.aorg.MyPractice.DS.Array;

public class FindNumberOfPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] a = new int[]{1, 2, 8, 10, 10, 12, 19};
			int key = 3;
			int floor = new FindNumberOfPairs().getFloor(a, key);
			int celing = new FindNumberOfPairs().getCeling(a,0,a.length, key);
			System.out.println(floor+" > "+a[celing]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	
	private int getFloor(int[] a,int key){
		try{
			int floor = Integer.MIN_VALUE;
			for(int i = 0;i<a.length;i++){
				if(floor<a[i]&&a[i]<key&&floor<key){
					floor = a[i];
				}
			}
			return floor;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getCeling(int[] a,int left,int right,int key){
		try{
			int mid = (left+right)/2;
			if(a[mid]==key){
				return mid;
			}
			if(a[mid]>key){
				if(mid-1>left&&(a[mid] > key&&a[mid-1]<key)){
					return mid;
				}
				return getCeling(a, left,mid-1, key);
			}
			if(a[mid]<key){
				if(mid+1<=right&&(a[mid] < key&&a[mid+1]>key)){
					return mid+1;
				}
				return getCeling(a, mid+1, right, key);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
