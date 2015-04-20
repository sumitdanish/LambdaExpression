package com.aorg.MyPractice.DS.Array;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class WeightedJobScheduling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			WeightedJobScheduling w = new WeightedJobScheduling();
			Scanner sc = new Scanner(new File("job.txt"));
			ArrayList<Job> jobList = new ArrayList<Job>();
			while(sc.hasNext()){
				String[] st = sc.next().split(",");
				int s = Integer.parseInt(st[0]);
				int ft = Integer.parseInt(st[1]);
				int pro = Integer.parseInt(st[2]);
				Job job = new Job(s,ft,pro,pro);
				jobList.add(job);
			}
			Collections.sort(jobList,new JobSort());
			for(Job j : jobList){
				System.out.println(j.getSTime()+" > "+j.getFTime()+" <><> "+j.getJobValue());
			}
			w.maxWeghtValue(jobList);
//			int maxProfit = w.getMaxProfit(jobList);
//			System.out.println(maxProfit);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getMaxProfit(ArrayList<Job> jobList){
		try{
			int[] storeProfit = new int[jobList.size()];
			int[] storeMaxProfit = new int[jobList.size()];
			storeMaxProfit[0]=jobList.get(0).getJobValue();
			storeProfit[0]=jobList.get(0).getJobValue();
			for(int i=1;i<jobList.size();i++){
				Job currentJob = jobList.get(i);
				for(int j=i-1;j>=0;j--){
					if(jobList.get(j).getFTime()<=currentJob.getSTime()){
						storeProfit[i] = storeMaxProfit[j]+currentJob.getJobValue();
						storeMaxProfit[i] = getMax(storeProfit[i],storeMaxProfit[i-1]);
					}
				}
			}
			return storeMaxProfit[jobList.size()-1];
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMax(int a,int b){
		return a>b?a:b;
	}
	
	
	/*Check this method again*/
	private void maxWeghtValue(ArrayList<Job> jobList){
		try{
			Stack<Job> st = new Stack<Job>();
			for(int j=0;j<jobList.size();j++){
				st.add(jobList.get(j));
				for(int i=j+1;i<jobList.size()-1;i++){
					Job preJob = st.peek();
					Job currJob=jobList.get(i);
					if(preJob.getFTime()<currJob.getSTime()&&preJob.getSTime()<currJob.getFTime())
					{
						st.pop();
						int cJob = currJob.getJobValue();
						int pJob = preJob.getTotalJob();
						if(cJob>pJob){
							preJob.setTotalJob(cJob+pJob);
							currJob.setTotalJob(cJob+pJob);
							//st.add(preJob);
							st.add(currJob);
						}else{
							st.add(preJob);
						}
					}
				}
			}
			while(!st.isEmpty()){
				Job job = st.peek();st.pop();
				System.out.println(job.getSTime()+" > "+job.getFTime()+" <> "+job.getJobValue()+" <<<>> "+job.getTotalJob());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}


class Job
{
	private int sTime;
	private int fTime;
	private int jobValue;
	private int totalJob;
	
	public Job(int sTime,int fTime,int jobValue,int totalJob){
		this.sTime = sTime;
		this.fTime = fTime;
		this.jobValue = jobValue;
		this.totalJob = totalJob;
	}

	public int getSTime() {
		return sTime;
	}

	public void setSTime(int time) {
		sTime = time;
	}

	public int getFTime() {
		return fTime;
	}

	public void setFTime(int time) {
		fTime = time;
	}

	public int getJobValue() {
		return jobValue;
	}

	public void setJobValue(int jobValue) {
		this.jobValue = jobValue;
	}

	public int getTotalJob() {
		return totalJob;
	}

	public void setTotalJob(int totalJob) {
		this.totalJob = totalJob;
	}
}
class JobSort implements Comparator<Job>{

	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		return o1.getFTime()-o2.getFTime();
	}
	
}