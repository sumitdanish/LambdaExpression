package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/*
 *May 7, 2015
 *SUMMIT
 *1:17:33 AM
 *2015
 *
 */
public class IsCycleInGraphDFS {

	public static void main(String[] args) {
		try{
			IsCycleInGraphDFS cycle=  new IsCycleInGraphDFS();
			Scanner sc = new Scanner(new File("cycl.txt"));
			int vertex = sc.nextInt();
			IsCycleInGraphDFS isCycle = new IsCycleInGraphDFS();
			CNodeList cnodeList = new CNodeList(sc, vertex);
			CNode[] nodeList = cnodeList.getNodeList();
			boolean[] isInStack = new boolean[vertex];
			for(int i = 0;i<vertex;i++){
				if(cycle.dfs(nodeList, 0, isInStack)){
					System.out.println("Cycle is there !");
					break;
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	public boolean dfs(CNode[] list,int src,boolean[] isInStack){
		try{
			list[src].setVisited(true);
			isInStack[src] = true;
			CNode li = list[src];
			while(li != null && li.getData() != -1){
				if(!list[li.getData()].isVisited() && dfs(list, li.getData(), isInStack)){
					return true;
				}
				if(isInStack[li.getData()]){
					return true;
				}
				li = li.getNext();
			}
			isInStack[src] = false;
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
}


class CNodeList
{
	private CNode[] nodeList;
	private int vertex;
	public CNodeList(Scanner sc,int vertex){
		this.vertex = vertex;
		String s = null;
		nodeList = new CNode[vertex];
		for(int i = 0;i<vertex;i++){
			nodeList[i] = new CNode(-1);
		}
		while(sc.hasNext() && !(s = sc.next()).equals("#")){
			String[] st = s.split(",");
			int src = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			addEadge(src, dest);
		}
	}
	
	public void setCNodeList(CNode[] list){
		this.nodeList = list;
	}
	public CNode[] getNodeList(){
		return nodeList;
	}
	public void addEadge(int src,int dest){
		nodeList[src] = nodeList[src].createNode(nodeList[src], dest);
	}
	
}


class CNode
{
	private int data;
	private CNode next;
	private boolean visited;
	public CNode(int data){
		this.data = data;
	}
	
	public void setNext(CNode next){
		this.next = next;
	}
	public CNode getNext(){
		return next;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	public boolean isVisited(){
		return visited;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	
	public CNode createNode(CNode node,int data){
		try{
			if(!isVertex(node, data)){
				CNode no = new CNode(data);
				no.setNext(node);
				node = no;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isVertex(CNode node,int data){
		try{
			CNode n = node;
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