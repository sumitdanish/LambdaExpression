/**
 * SU915198
 * 11:36:51 PM
 * 2015
 */
package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.Scanner;

/**
 * @author SU915198
 *
 */
public class IsCycleInGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			IsCycleInGraph isCycleInGraph = new IsCycleInGraph();
			Scanner sc = new Scanner(new File("cycl.txt"));
			int eadge = sc.nextInt();
			
			GraphCycle gc = new GraphCycle(eadge, sc);
			boolean p = gc.isCycle(eadge);
			System.out.println(p);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
}

class GraphCycle
{
	private int eadge;
	private GraphC eadgeCycle;
	private int[] rank;
	private int[] parent;
	private int vertex;
	private int i = 0;
	public  GraphCycle(int eadge,Scanner sc){
		eadgeCycle = new GraphC(eadge);
		parent = new int[eadge];
		rank = new int[eadge];
		for(int k = 0;k<eadge;k++){
			rank[k] = 0;
			parent[k] =-1;
		}
		while(sc.hasNext()){
			String[] st = sc.next().split(",");
			int src = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			eadgeCycle.getEadgeCycle()[i].setSrc(src);
			eadgeCycle.getEadgeCycle()[i].setDest(dest);
			//union(src, dest);
			i++;
		}
	}
	
	public int find(int i){
		try{
			if(parent[i] == -1){
				return i;
			}
			return find(parent[i]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public void union(int src,int dest){
		try{
			if(find(src) == find(dest)){
				return;
			}
			parent[src] = dest;
			if(rank[src] > rank[dest]){
				parent[dest] = src;
			}else if(rank[src] < rank[dest]){
				parent[src] = dest;
			}else{
				parent[src] = dest;
				rank[dest]++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public GraphC getGraphC(){
		return eadgeCycle;
	}
	public boolean isCycle(int eadge){
		try{
			for(int i = 0;i<eadge;i++){
				int src = getGraphC().getEadgeCycle()[i].getSrc();
				int dest = getGraphC().getEadgeCycle()[i].getDest();
				if(find(src) == find(dest)){
					return true;
				}
				union(src, dest);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
class GraphC
{
	private EadgeCycle[] eadgeCycle;
	private int eadge;
	private int vertex;
	public GraphC(int eadge){
		this.eadge = eadge;
		eadgeCycle = new EadgeCycle[eadge];
		for(int i = 0;i<eadge;i++){
			eadgeCycle[i] = new EadgeCycle();
		}
	}
	public EadgeCycle[] getEadgeCycle(){
		return eadgeCycle;
	}
}
class EadgeCycle
{
	private int src;
	private int dest;
	public EadgeCycle(){
		
	}
	public EadgeCycle(int src,int dest){
		this.src = src;
		this.dest = dest;
	}
	public void setSrc(int src){
		this.src = src;
	}
	public void setDest(int dest){
		this.dest = dest;
	}
	public int getSrc(){
		return src;
	}
	public int getDest(){
		return dest;
	}
}