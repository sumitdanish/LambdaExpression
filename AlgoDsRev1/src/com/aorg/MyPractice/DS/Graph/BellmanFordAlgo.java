package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
/*
 *Apr 26, 2015
 *SUMMIT
 *12:55:37 AM
 *2015
 *
 */
public class BellmanFordAlgo {

	public static void main(String[] args) {
		try{
			BellmanFordAlgo bf = new BellmanFordAlgo();
			Scanner sc = new Scanner(new File("dijasktra.txt"));
			int vertex = sc.nextInt();
			BNodeList node = new BNodeList(vertex, sc);
			int[] dist = new int[vertex];
			for(int i = 0;i<vertex;i++){
				dist[i] = 0;
			}
			dist[0] = 0;
			int src = 0;
			int[][] weight = node.getWeight();
			BNode[] nodeList = node.getBNodeList();
//			while(nodeList[0] != null){
//				System.out.print(nodeList[0].getData()+",");
//				nodeList[0] = nodeList[0].getNext();
//			}
			bf.bellManFor(nodeList, src, dist, vertex, weight);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	public void bellManFor(BNode[] node,int src,int[] dist,int vertex,int[][] weight){
		try{
			int[] path = new int[vertex];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(src);
			node[src].setVisited(true);
			while(!q.isEmpty()){
				int v = q.poll();
				BNode n = node[v];
				while(n.getNext() != null ){
					int v1 = n.getData();
					if(!node[v1].isVisited()){
						int d = dist[v]+weight[v][v1];
						//System.out.println(v+" > "+v1+" > "+weight[v][v1]);
						if(dist[v1] > d){
							dist[v] = d;
							path[v1] = v;
							q.add(v1);
							n.setVisited(true);
						}
					}
					n = n.getNext();
				}
			}
			for(int i = 0;i<vertex;i++){
				System.out.print(i+" > "+dist[i]+"\n");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
class BNodeList
{
	private BNode[] bnodeList;
	private int vertex;
	private int[][] weight;
	String s;
	public BNodeList(int vertex,Scanner sc){
		this.vertex = vertex;
		bnodeList = new BNode[vertex];
		weight = new int[vertex][vertex];
		for(int i = 0;i<vertex;i++){
			bnodeList[i] = new BNode(i);
		}
		while(sc.hasNext() && !(s = sc.next()).equals("#")){
			String[] st = s.split(",");
			int src = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			int w = Integer.parseInt(st[2]);
			weight[src][dest] = w;
			addEadge(src, dest);
		}
	}
	
	public BNode[] getBNodeList(){
		return bnodeList;
	}
	public int[][] getWeight(){
		return weight;
	}
	public void addEadge(int src,int dest){
		bnodeList[src] = bnodeList[src].createList(bnodeList[src], dest);
	}
}
class BNode
{
	private int data;
	private BNode next;
	private boolean visited;
	public BNode(){
		
	}
	public BNode(int data){
		this.data = data;
	}
	public void setNext(BNode next){
		this.next = next;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public BNode getNext(){
		return next;
	}
	public int getData(){
		return data;
	}
	public boolean isVisited(){
		return visited;
	}
	
	public BNode createList(BNode node,int data){
		try{
			if(!isVertex(node, data)){
				BNode n = new BNode(data);
				n.setNext(node);;
				node = n;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isVertex(BNode node,int data){
		try{
			BNode n = node;
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
