package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.Scanner;

public class ArticulationPoint {

	public static void main(String[] args) {
		
		try{
			Scanner sc = new Scanner(new File("articulation.txt"));
			int vertex = sc.nextInt();
			APNodeList apList = new APNodeList(vertex);
			String s = new String();
			while(sc.hasNext() && !(s=sc.next()).equals("#")){
				String[] st = s.split("-->");
				int src = Integer.parseInt(st[0]);
				int dest = Integer.parseInt(st[1]);
				apList.addEadge(src, dest);
			}
			APNode[] apnodeList = apList.getAPNodeList();
			apList.apUtil(apnodeList);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	
	
	
}


class APNodeList
{
	private APNode[] apnodeList; 
	private int vertex;
	private int time;
	public APNodeList(int vertex){
		this.vertex = vertex;
		apnodeList = new APNode[vertex];
		for(int i = 0;i<vertex;i++){
			apnodeList[i] = new APNode();
		}
	}
	public void setAPNodeList(APNode[] apnodeList){
		this.apnodeList = apnodeList;
	}
	public APNode[] getAPNodeList(){
		return apnodeList;
	}
	public void addEadge(int src,int dest){
		apnodeList[src] = apnodeList[src].createList(apnodeList[src], dest);
	}
	
	public void apUtil(APNode[] apnodeList){
		try{
			boolean[] ap = new boolean[vertex];
			int[] parent = new int[vertex];
			int[] desc = new int[vertex];
			int[] low = new int[vertex];
			boolean[] visited = new boolean[vertex];
			for(int i = 0;i<vertex;i++){
				parent[i] = -1;
				desc[i] = -1;
				low[i] = -1;
			}
			
			for(int i = 0;i<vertex;i++){
				if(!visited[i]){
					articulatioPoint(desc, low, i, parent, ap, apnodeList,visited);
				}
			}
			for(int k = 0;k<vertex;k++){
				if(ap[k]){
					System.out.print(k+",");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void articulatioPoint(int[] desc,int[] low,int src,int[] parent,boolean[] ap,APNode[] node,boolean[] visited){
		try{
			visited[src] = true;
			time = time+1;
			desc[src] = time;
			low[src] = time;
			int count = 0;
			APNode n = node[src];
			while(n .getNext()!= null){
				if(!visited[n.getData()]){
					count++;
					parent[n.getData()] = src;
					articulatioPoint(desc, low, n.getData(), parent, ap, node,visited);
					low[src] = getMin(low[n.getData()], low[src]);
					if(parent[src] == -1 && count > 1){
						ap[src] = true;
					}
					if(parent[src] != -1 && low[n.getData()] >= desc[src]){
						ap[src] = true;
					}
				}else if((visited[n.getData()])&&(n.getData() != parent[src])){
					low[src] = getMin(desc[n.getData()],low[src]);
				}
				n = n.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public int getMin(int a,int b){
		return a > b ? b : a;
	}
}




class APNode
{
	private int data;
	private APNode next;
	private boolean visited;
	public APNode(){
		
	}
	public APNode(int data){
		this.data = data;
	}
	public void setNext(APNode next){
		this.next = next;
	}
	public APNode getNext(){
		return next;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	public boolean isVisited(){
		return visited;
	}
	
	
	public APNode createList(APNode node,int data){
		try{
			if(!isVertex(node, data)){
				APNode n = new APNode(data);
				n.setNext(node);
				node = n;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isVertex(APNode node,int data){
		try{
			APNode n = node;
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