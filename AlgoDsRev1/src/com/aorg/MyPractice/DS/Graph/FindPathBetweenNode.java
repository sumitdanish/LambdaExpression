package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.Scanner;

/*
 *May 8, 2015
 *SUMMIT
 *10:50:14 PM
 *2015
 *
 */
public class FindPathBetweenNode {

	public static void main(String[] args) {
		try{
			FindPathBetweenNode fp = new FindPathBetweenNode();
			Scanner sc = new Scanner(new File("fpath.txt"));
			int vertex = sc.nextInt();
			PathNodeList pn = new PathNodeList(vertex, sc);
			PathNode[]  path = pn.getNodeList();
			boolean b = fp.isPathDfs(path,1, 3,new boolean[vertex]);
			if(b){
				System.out.println("Path");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
		
	
	public boolean isPathDfs(PathNode[] path,int src,int dest,boolean[] isStack){
		try{
			if(src == dest){
				return true;
			}
			path[src].setvisited(true);
			isStack[src] = true;
			PathNode pn = path[src];
			while(pn != null && pn.getData() != -1){
				if(!path[pn.getData()].isVisited() && isPathDfs(path, pn.getData(), dest, isStack)){
					return true;
				}
				pn = pn.getNext();
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
}


class PathNodeList
{
	private PathNode[] nodeList;
	private int vertex;
	public PathNodeList(int vertex,Scanner sc){
		this.vertex = vertex;
		nodeList = new PathNode[vertex];
		for(int i = 0; i <vertex;i++){
			nodeList[i] = new PathNode(-1);
		}
		while(sc.hasNext()){
			String[] st = sc.next().split(",");
			int src = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			addEadge(src, dest);
		}
	}
	
	public PathNode[] getNodeList(){
		return nodeList;
	}
	public void addEadge(int src,int dest){
		nodeList[src] = nodeList[src].createNode(nodeList[src], dest);
	}
}



class PathNode
{
	private int data;
	private PathNode next;
	private boolean visited;
	public PathNode(int data){
		this.data = data;
	}
	
	public void setNext(PathNode next){
		this.next = next;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setvisited(boolean visited){
		this.visited = visited;
	}
	public int getData(){
		return data;
	}
	public PathNode getNext(){
		return next;
	}
	public boolean isVisited(){
		return visited;
	}
	
	public PathNode createNode(PathNode node,int data){
		try{
			if(!isVertex(node, data)){
				PathNode pa = new PathNode(data);
				pa.setNext(node);
				node = pa;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	public boolean isVertex(PathNode node,int data){
		try{
			PathNode p = node;
			while(p != null && p.getData() != -1){
				if(p.getData() == data){
					return true;
				}
				p = p.getNext();
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}