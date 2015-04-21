/**
 * 
 */
package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.Scanner;

/**
 * @author SU915198
 *
 */
public class DFSTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("dfstime.txt"));
			int vertex = sc.nextInt();
			TNodeList tnodeList = new TNodeList(vertex);
			while(sc.hasNext()){
				String[] st = sc.next().split("-->");
				int src = Integer.parseInt(st[0]);
				int dist = Integer.parseInt(st[1]);
				tnodeList.addEadge(src, dist);
			}
			sc.close();
			TNode[]  node = tnodeList.getTNode();
			tnodeList.dfsTime(node,0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	
}
class TNodeList
{
	private TNode[] tnode;
	private int vertex;
	private int time = 0;
	public TNodeList(int vertex){
		this.vertex = vertex;
		tnode = new TNode[vertex];
		for(int i = 0;i< vertex;i++){
			tnode[i] = new TNode();
		}
	}
	public void setTNodeList(TNode[] tnode){
		this.tnode = tnode;
	}
	public TNode[] getTNode(){
		return tnode;
	}
	public void setVertex(int vertex){
		this.vertex = vertex;
	}
	public int getVertex(){
		return vertex;
	}
	public void addEadge(int src,int dist){
		tnode[src] = tnode[src].createNode(tnode[src],dist);
	}
	public void dfsTime(TNode[] tnode,int src){
		try{
			tnode[src].setStV(true);
			time = time + 1;
			tnode[src].setStTime(time);
			TNode node = tnode[src];
			while(node != null){
				if(!tnode[node.getData()].getStV()){
					dfsTime(tnode,node.getData());
				}
				node = node.getNext();
			}
			tnode[src].setEndV(true);
			time=time + 1;
			tnode[src].setEndTime(time);
			System.out.println(tnode[src].getStTime()+" > "+tnode[src].getEndTime());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
class TNode
{
	private int data;
	private TNode next;
	private boolean stV;
	private boolean endV;
	private int stTime;
	private int endTime;
	public TNode(){
		
	}
	public TNode(int data){
		this.data = data;
	}
	
	public void setNext(TNode next){
		this.next = next;
	}
	public TNode getNext(){
		return next;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public void setStV(boolean stV){
		this.stV = stV;
	}
	public boolean getStV(){
		return stV;
	}
	public void setEndV(boolean endV){
		this.endV = endV;
	}
	public boolean getEndV(){
		return endV;
	}
	public void setStTime(int stTime){
		this.stTime = stTime;
	}
	public void setEndTime(int endTime){
		this.endTime = endTime;
	}
	public int getStTime(){
		return stTime;
	}
	public int getEndTime(){
		return endTime;
	}
	public TNode createNode(TNode node,int data){
		try{
			if(!isVertex(node, data)){
				TNode n = new TNode(data);
				n.setNext(node);
				node = n;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	public boolean isVertex(TNode node,int data){
		try{
			TNode n = node;
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