package com.aorg.MyPractice.DS.Graph;

public class ArticulationPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	public void apUtil(){
		try{
			boolean[] ap = new boolean[vertex];
			int[] parent = new int[vertex];
			int[] desc = new int[vertex];
			int[] low = new int[vertex];
			APNode[] nodeList = getAPNodeList(); 
			for(int i = 0;i<vertex;i++){
				articulatioPoint(desc, low, i, parent, ap, nodeList);
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
	
	public void articulatioPoint(int[] desc,int[] low,int src,int[] parent,boolean[] ap,APNode[] node){
		try{
			node[src].setVisited(true);
			time++;
			desc[src] = time;
			low[src] = time;
			int count = 0;
			APNode n = node[src];
			while(n != null){
				int v = n.getData();
				if(!node[v].isVisited()){
					count++;
					parent[v] = src;
					articulatioPoint(desc, low, v, parent, ap, node);
					low[src] = getMin(low[v], low[src]);
					if(parent[src] == 0 && count > 1){
						ap[src] = true;
					}
					if(parent[src] != 0 && low[v] >= desc[src]){
						ap[src] = true;
					}
				}else if(v != parent[src]){
					low[src] = getMin(desc[v],low[src]);
				}
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