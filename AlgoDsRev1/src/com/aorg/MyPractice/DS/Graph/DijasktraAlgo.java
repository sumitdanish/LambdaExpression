package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 *Apr 25, 2015
 *SUMMIT
 *10:17:50 PM
 *2015
 *
 */
public class DijasktraAlgo {

	public static void main(String[] args) {
		try{
			DijasktraAlgo dj = new DijasktraAlgo();
			Scanner sc = new Scanner(new File("dijasktra.txt"));
			int vertex = sc.nextInt();
			DJNodeList nodeList = new DJNodeList(vertex, sc);
			int[] dist = new int[vertex];
			DJNode[] node = nodeList.getDJNodeList();
			int[][] weight = nodeList.getWeight();
			int src = 0;
			for(int i = 0;i<vertex;i++){
				dist[i] = -1;
			}
			dj.dijasktra(node, src, vertex, dist, weight);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public void dijasktra(DJNode[] node,int src,int vertex,int[] dist,int[][] weight){
		try{
			PriorityQueue<Integer> q =new PriorityQueue<Integer>();
			q.add(src);
			int[] path = new int[vertex];
			node[src].setVisited(true);
			while(!q.isEmpty()){
				int v = q.poll();
				DJNode dn =node[v];
				while(dn != null && dn.getData() !=-1){
					int v1 = dn.getData();
					if(!node[v1].getVisited()){
						int d = dist[v1]+weight[v][v1];
						if(dist[v1] == -1){
							dist[v1] = d;
							path[v1] = v;
							node[v1].setVisited(true);
							q.add(v1);
						}
						if(dist[v1] > d){
							q.remove(v1);
							dist[v1] = d;
							path[v1] = v;
							node[v1].setVisited(true);
							q.add(v1);
						}
					}
					dn = dn.getNext();
				}
			}
			for(int i = 0;i<vertex;i++){
				System.out.print(i+" > "+path[i]+",\n");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
}

class DJNodeList
{
	private DJNode[] nodeList;
	private int vertex;
	String s;
	private int[][] weight;
	public DJNodeList(int vertex,Scanner sc){
		this.vertex = vertex;
		nodeList = new DJNode[vertex];
		for(int i = 0;i<vertex;i++){
			nodeList[i] = new DJNode(-1);
		}
		weight = new int[vertex][vertex];;
		while(sc.hasNext() && !(s=sc.next()).equals("#")){
			String[] st = s.split(",");
			int src = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			int w = Integer.parseInt(st[2]);
			weight[src][dest] = w;
			addEadge(src, dest);
		}
	}
	public void setDJNodeList(DJNode[] nodeList){ 
		this.nodeList = nodeList;
	}
	public DJNode[] getDJNodeList(){
		return nodeList;
	}
	public void setWeight(int[][] weight){
		this.weight = weight;
	}
	public int[][] getWeight(){
		return weight;
	}
	public void addEadge(int src,int dest){
		nodeList[src] = nodeList[src].createList(nodeList[src], dest);
	}
}

class DJNode
{
	private int data;
	private DJNode next;
	private boolean visited;
	public DJNode(){
		
	}
	public DJNode(int data){
		this.data = data;
	}
	public void setVisited(boolean visited){
		this.visited =visited;
	}
	public boolean getVisited(){
		return visited;
	}
	public void setDJNode(DJNode next){
		this.next = next;
	}
	public void setData(int data){
		this.data =data;
	}
	public int getData(){
		return data;
	}
	public DJNode getNext(){
		return next;
	}
	public DJNode createList(DJNode node,int data){
		try{
			if(!node.getVisited()){
				DJNode n = new DJNode(data);
				n.setDJNode(node);
				node = n;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	public boolean isVertex(DJNode next,int data){
		try{
			DJNode n = next;
			while(n != null){
				if(n.getData() == data){
					return true;
				}
				n = n.getNext();
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
