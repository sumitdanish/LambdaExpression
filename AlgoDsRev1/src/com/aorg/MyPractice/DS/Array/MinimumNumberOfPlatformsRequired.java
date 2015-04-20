package com.aorg.MyPractice.DS.Array;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class MinimumNumberOfPlatformsRequired {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			MinimumNumberOfPlatformsRequired m = new MinimumNumberOfPlatformsRequired();
			Scanner sc = new Scanner(new File("pa.txt"));
			ArrayList<Interval> intList = new ArrayList<Interval>();
			while(sc.hasNext()){
				String[] s = sc.next().split(",");
				Double start = Double.parseDouble(s[0]);
				Double  end =  Double.parseDouble(s[1]);
				Interval interval = new Interval(start,end);
				intList.add(interval);
			}
			Collections.sort(intList,new IntervalSort());
			int p = m.getMaxPlatfor(intList);
			System.out.println(p);
//			for(Interval inte : intList){
//				System.out.println(inte.getStart()+" > "+inte.getEnd());
//			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	/*
	 * We can get the max Number of platfor if we will think closely then max platform is nothing but
	 * to get the count of interval which is overlapping to each other
	 * */
	private int getMaxPlatfor(ArrayList<Interval> intList){
		try{
			int c=0;
			Stack<Interval> stack = new Stack<Interval>();
			stack.push(intList.get(0));
			for(int i=1;i<intList.size();i++){
				Interval p = stack.pop();
				if(p.getEnd()>intList.get(i).getStart()&&p.getStart()<intList.get(i).getEnd()){
					c++;
				}
				stack.push(intList.get(i));
			}
			return c;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
class Interval
{
	private Double start;
	private Double end;
	public Interval(Double start,Double end){
		this.start = start;
		this.end   = end;
	}
	public void setStart(Double start){
		this.start = start;
	}
	public void setEnd(Double end){
		this.end = end;
	}
	
	public Double getStart(){
		return start;
	}
	public Double getEnd(){
		return end;
	}
}

class IntervalSort implements Comparator<Interval>
{

	@Override
	public int compare(Interval in1,Interval in2){
		return (int)(in1.getStart()-in2.getStart());
	}
	
	
}