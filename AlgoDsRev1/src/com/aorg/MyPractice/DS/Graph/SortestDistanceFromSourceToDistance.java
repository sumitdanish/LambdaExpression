package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * SUMMIT
 * 8:07:42 PM
 * 2015
 */
public class SortestDistanceFromSourceToDistance {

	public static void main(String[] args) {
		try{
			SortestDistanceFromSourceToDistance sor = new SortestDistanceFromSourceToDistance();
			Scanner sc = new Scanner(new File("path.txt"));
			int vertex = sc.nextInt();
			SNodeList snodeList = new SNodeList(vertex, sc);
			SNode[] node = snodeList.getSnodeList();
			int src = 0;
			sor.sortestPathUnWeight(node, vertex, src);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void sortestPathUnWeight(SNode[] node,int vertex,int src){
		try{
			int[]  dist = new int[vertex];
			for(int i = 0;i<vertex;i++){
				dist[i] = -1;
			}
			dist[0] = 0;
			int[] path = new int[vertex];
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(src);
			while(!que.isEmpty()){
				int v = que.poll();
				SNode n = node[v];
				while(n != null){
					int v1 = n.getData();
					if(!node[v1].isVisited() && dist[v1] == -1){
						dist[v1] = dist[v]+1;
						path[v1] = v;
						node[v1].setVisited(true);
						que.add(v1);
					}
					n = n.getNext();
				}
			}
			for(int i = 0;i<vertex;i++){
				System.out.print(i+" > "+path[i]+",\n");
			}
		}catch(Exception ex){
			
		}
	}
	
	public int getVisited(SNode[] n,int src){
		try{
			SNode node = n[src];
			while(node!=null){
				if(!node.isVisited()){
					return node.getData();
				}
				node = node.getNext();
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}

class SNodeList
{
	private SNode[] snodeList;
	private int vertex;
	String s;
	public SNodeList(int vertex,Scanner sc){
		this.vertex = vertex;
		snodeList = new SNode[vertex];
		for(int  i= 0;i<this.vertex;i++){
			snodeList[i] = new SNode();
		}
		
		while(sc.hasNext()&& !(s=sc.next()).equals("#")){
			String[] st = s.split("-->");
			int src = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			addEadge(src, dest);
		}
	}
	
	public SNode[] getSnodeList(){
		return snodeList;
	}
	
	public void addEadge(int src,int dest){
		snodeList[src] = snodeList[src].createList(snodeList[src], dest);
	}
	
}

class SNode
{
	private SNode next;
	private int data;
	private boolean visited;
	public SNode(){
		
	}
	public SNode(int data){
		this.data = data;
	}
	public void setNext(SNode next){
		this.next = next;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public int getData(){
		return data;
	}
	public SNode getNext(){
		return next;
	}
	public boolean isVisited(){
		return visited;
	}
	
	public SNode createList(SNode node,int data){
		try{
			if(!isVertex(node,data)){
				SNode n = new SNode(data);
				n.setNext(node);
				node = n;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isVertex(SNode node,int data){
		try{
			SNode n = node;
			while(n != null){
				if(n.getData()==data){
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