package com.aorg.MyPractice.DS.Array;

public class FindkClosestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try{
			int[] a = {12,16,22,30,35, 39, 42,45, 48, 50, 53, 55, 56};
			int key = 35;
			int k=4;
			FindkClosestElements fk = new FindkClosestElements();
			fk.findElements(a, key, k);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private void findElements(int[] a,int key,int k){
		try{
			int count=0;
			int ind = getIndex(a,0,a.length-1, key);
			int i=ind-1;
			int j=ind+1;
			//System.out.println(ind);
			while(i>0&&j<a.length&&count<k){
				if(key-a[i]>a[j]-key){
					System.out.println(a[j]);
					j++;
				}else{
					System.out.println(a[i]);
					i--;
				}
				count++;
			}
			while(count<k&&i>=0){
				System.out.println(a[i]);
				i--;
				count++;
			}
			while(count<k&&j<a.length){
				System.out.println(a[j]);
				count++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private int getIndex(int[] a,int l,int r,int key){
		try{
			int m = (l+r)/2;
			if(a[r]<key){
				return r;
			}
			if(a[l]>key){
				return l;
			}
			if(a[m]==key){
				return m;
			}
			if(m-1>l&&a[m]>key){
				return getIndex(a, l,m-1, key);
			}
			if(m+1<=r){
				return getIndex(a,m+1,r, key);
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
