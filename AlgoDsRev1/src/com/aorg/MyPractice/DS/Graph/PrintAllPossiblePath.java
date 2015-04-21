package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.Scanner;

public class PrintAllPossiblePath {

	public static void main(String[] args) {
		try{
			PrintAllPossiblePath pp = new PrintAllPossiblePath();
			Scanner sc = new Scanner(new File("sortesPath.txt"));
			int vertex = sc.nextInt();
			PNodeList plist = new PNodeList(vertex);
			while(sc.hasNext()){
				String[] st = sc.next().split("-->");
				int src = Integer.parseInt(st[0]);
				int dest = Integer.parseInt(st[1]);
				plist.addEadge(src, dest);
			}
			sc.close();
			PNode[] node = plist.getPnodeList();
			
			pp.printPath(node,0,new int[vertex],2,3);;
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	public void printPath(PNode[] pnode,int ind,int[] path,int src,int dest){
		try{
			pnode[src].setVisted(true);
			path[ind] = src;
			ind++;
			if(src == dest){
				for(int i =0;i<ind;i++){
					System.out.print(path[i]+",");
				}
				System.out.println();
			}else{
				PNode node = pnode[src];
				while(node != null){
					if(!pnode[node.getData()].getVisited()){
						printPath(pnode, ind, path, node.getData(), dest);
					}
					node = node.getNext();
				}
			}
			ind--;
			pnode[src].setVisted(false);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}


class PNodeList
{
	private PNode[] pnodeList;
	private int vertex;
	public PNodeList(int vertex){
		this.vertex = vertex;
		pnodeList = new PNode[vertex];
		for(int i = 0; i< vertex ;i++){
			pnodeList[i] = new PNode();
		}
	}
	public void setPNodeList(PNode[] pnodeList){
		this.pnodeList = pnodeList;
	}
	public PNode[] getPnodeList(){
		return pnodeList;
	}
	public void setVertex(int vertex){
		this.vertex = vertex;
	}
	public int getVertex(){
		return vertex;
	}
	public void addEadge(int src,int dest){
		pnodeList[src] = pnodeList[src].createNode(pnodeList[src], dest);
	}
}

class PNode
{
	private int data;
	private PNode next;
	private boolean visited;
	public PNode(){
		
	}
	public PNode(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setNext(PNode next){
		
	}
	public void setVisted(boolean visited){
		
	}
	public int getData(){
		return data;
	}
	public  PNode getNext(){
		return next;
	}
	public boolean getVisited(){
		return visited;
	}
	
	
	public PNode createNode(PNode node,int data){
		try{
			if(!isVertex(node, data)){
				PNode p = new PNode(data);
				p.setNext(node);
				node = p;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isVertex(PNode node,int data){
		try{
			PNode p = node;
			while(p != null){
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
