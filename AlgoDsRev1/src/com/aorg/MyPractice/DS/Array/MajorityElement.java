package com.aorg.MyPractice.DS.Array;

public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {2,5,3,5,5,3,5};
			int ele = new MajorityElement().getMajority(a);
			System.out.println(ele);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public int getMajority(int[] a){
		try{
			int count = 0;
			int count1 = 0;
			int ele = a[0];
			for(int i=1; i <a.length ; i++){
				if(count == 0){
					ele = a[i];
					count = 1;
				}else{ 
					if(ele == a[i]){
					count++;
				}else{
					count--;
				}
			}
		}
		int ele1 = 0;
		count = 0;
		for(int i = 0; i <a.length ; i++){
			if(ele == a[i]){
				count++;
			}else if(count1 == 0){
				ele1 = a[i];
				count1 = 1;
			}else if(ele1 == a[i] && count1 < count){
				count1++;
			}else{
				count1--;
			}
		}
		System.out.println(count+"2nd Majority element > "+ele1);
		if(count > (a.length/2)){
			return ele;
		}else{
			return ele1;
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
