package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class SCComponent {

	static int time=0;
	public static void main(String[] args) {
		
		try{
			SCComponent scomponent = new SCComponent();
			Scanner sc = new Scanner(new File("scc.txt"));
			int vertex = sc.nextInt();
			SCCNodeList sccNodeList = new SCCNodeList(vertex);
			String s = new String();
			int[] low = new int[vertex];
			int[] desc = new int[vertex];
			
			while(sc.hasNext() && !(s = sc.next()).equals("#")){
				String[] st = s.split("-->");
				int src = Integer.parseInt(st[0]);
				int dest = Integer.parseInt(st[1]);
				sccNodeList.addEadge(src, dest);
			}
			SCCNode[]  node = sccNodeList.getSCCNodeList();
			for(int i = 0;i<vertex;i++){
				low[i] = -1;
				desc[i] = -1;
			}
			for(int i = 0;i<vertex;i++){
				if(!node[i].getVisited()){
					scomponent.stronglyConnected(node, low, desc,new Stack<Integer>(),i);
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void stronglyConnected(SCCNode[]  node,int[] low,int[] desc,Stack<Integer> st,int src){
		try{
			node[src].setVisited(true);
			st.add(src);
			time++;
			low[src] = time;
			desc[src] = time;
			SCCNode n = node[src];
			while(n != null && n.getData() != -1){
				int v = n.getData();
				if(desc[v] == -1){
					stronglyConnected(node, low, desc, st, v);
					low[src] = getMin(low[src],low[v]);
				}else if(node[src].getVisited()){
					low[src] = getMin(low[src],desc[v]);
				}
				n = n.getNext();
			}
			int w = 0;
			if(low[src] == desc[src]){
				while(st.peek() != src){
					w = st.peek();
					System.out.print(w+",");
					st.pop();
				}
				w = st.pop();
				System.out.print(w+",");
				node[w].setVisited(false);
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int getMin(int a,int b){
		return a > b ? b: a;
	}
}
class SCCNodeList
{
	private SCCNode[] sccNodelist;
	private int vertex;
	public SCCNodeList(int vertex){
		this.vertex = vertex;
		sccNodelist = new SCCNode[vertex];
		for(int i = 0;i<vertex;i++){
			sccNodelist[i] = new SCCNode(-1);
		}
	}
	public void setSCCNodeList(SCCNode[] sccNodeList){
		this.sccNodelist = sccNodeList;
	}
	
	public void setVertex(int vertex){
		this.vertex = vertex;
	}
	public SCCNode[] getSCCNodeList(){
		return sccNodelist;
	}
	public int getVertex(){
		return vertex;
	}
	public void addEadge(int src,int dest){
		sccNodelist[src] = sccNodelist[src].createList(sccNodelist[src], dest);
	}
	
}
class SCCNode
{
	private int data;
	private SCCNode next;
	private boolean visited;
	public SCCNode(int data){
		this.data = data;
	}
	public SCCNode(){
		
	}
	public void setData(int data){
		this.data = data;
	}
	public void setNext(SCCNode next){
		this.next = next;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	public int getData(){
		return data;
	}
	public SCCNode getNext(){
		return next;
	}
	public boolean getVisited(){
		return visited;
	}
	public SCCNode createList(SCCNode node,int data){
		try{
			if(!isVertex(node, data)){
				SCCNode n = new SCCNode(data);
				n.setNext(node);
				node = n;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	public boolean isVertex(SCCNode node,int data){
		try{
			SCCNode n = node;
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