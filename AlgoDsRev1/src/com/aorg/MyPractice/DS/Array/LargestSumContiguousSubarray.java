package com.aorg.MyPractice.DS.Array;

public class LargestSumContiguousSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = { 2,3,-3,-4,5,6};
			new LargestSumContiguousSubarray().getMax(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getMax(int[] a){
		try{
			int max_so_far = 0;
			int max_sum_end_here = 0;
			int st = 0;
			int end = 0;
			boolean flag = true;
			for(int i = 0;i < a.length ; i++){
				max_sum_end_here+=a[i];
				if(max_sum_end_here > 0 && flag){
					st = i;
					flag = !flag;
				}
				if(max_sum_end_here < 0){
					max_sum_end_here = 0;
					flag = true;
				}else if(max_so_far < max_sum_end_here){
					end = i;
					max_so_far = max_sum_end_here;
				}
			}
			System.out.println(max_so_far +" > "+st+" > "+end);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
