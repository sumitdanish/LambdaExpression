package com.aorg.MyPractice.DS.Array;

public class MajorityElementForOddOccurence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] a = {1,2,3,2,3,1,3};
			int ele = new MajorityElementForOddOccurence().getOddOcurence(a);
			System.out.println(ele);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getOddOcurence(int[] a){
		try{
			int count = 0;
			int ele = a[0];
			for(int i = 0;i< a.length ; i++){
				if(count == 0){
					count++;
					ele = a[i];
				}else{
					if(ele == a[i]){
						count++;
					}else{
						count--;
					}
				}
			}
			count = 0;
			for(int i = 0; i <a.length ; i++){
				if(ele == a[i]){
					count++;
				}
			}
			if(count %2 != 0){
				return ele;
			}else{
				return -1;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
