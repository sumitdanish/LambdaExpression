package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



/*         1         5
 *  [0]------->[1]------->[2]
 *     \        |        ^ |
 *      \       |       /  |
 *       \      |      /   |
 *      2 \    1|   3 /    |4
 *         \    |    /     |
 *          \   |   /      |
 *           V  v  /       v
 *             [3]-------->[4]
 *                  7
 * 
 */


public class DFSAndBFS {

	public static void main(String[] args) {
		try{
			DFSAndBFS dbfs = new DFSAndBFS();
			Scanner sc = new Scanner(new File("dfs.txt"));
			int vertex = sc.nextInt();
			NodeList nodeList = new NodeList(vertex);
			while(sc.hasNext()){
				String[] st = sc.next().split(",");
				int src = Integer.parseInt(st[0]);
				int dest = Integer.parseInt(st[1]);
				nodeList.addEadge(src, dest);
			}
			Node[] node = nodeList.getNodeList();
			int src = 0;
			dbfs.dfsWithRecursion(node, src);
			//dbfs.bfs(node, src);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public void dfsWithOutRecusrsion(Node[] node,int src){
		try{
			Stack<Integer> st = new Stack<Integer>();
			st.add(src);
			node[src].setVisited(true);
			while(!st.isEmpty()){
				int v = getUnvisitedVertex(node,st.peek());
				if(v == -1){
					st.pop();
				}else{
					st.add(v);
					node[v].setVisited(true);
					System.out.print(v+",");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void dfsWithRecursion(Node[] node,int src){
		try{
			node[src].setVisited(true);
			Node n = node[src];
			System.out.print(src+",");
			while(n != null){
				if(!node[n.getData()].isVisited()){
					dfsWithRecursion(node,n.getData());
				}
				n = n.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void bfs(Node[] node,int src){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		node[src].setVisited(true);
		while(!q.isEmpty()){
			int v = 0;
			while((v = getUnvisitedVertex(node,q.poll())) != -1){
				node[v].setVisited(true);
				q.add(v);
				System.out.print(v+",");
			}
		}
	}
	public int getUnvisitedVertex(Node[] node,int src){
		try{
			Node n = node[src];
			while(n != null){
				if(!node[n.getData()].isVisited()){
					return n.getData();
				}
				n = n.getNext();
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}

}
class NodeList
{
	private Node[] nodeList;
	private int vertex;
	public NodeList(int vertex){
		this.vertex = vertex;
		nodeList = new Node[vertex];
		for(int i = 0;i<vertex;i++){
			nodeList[i] = new Node();
		}
	}
	
	public void setNodeList(Node[] nodeList){
		this.nodeList = nodeList;
	}
	public Node[] getNodeList(){
		return nodeList;
	}
	public void addEadge(int src,int dest){
		nodeList[src] = nodeList[src].createList(nodeList[src], dest);
	}
}
class Node
{
	private int data;
	private Node next;
	private boolean visited;
	public Node(){
		
	}
	public Node(int data){
		this.data = data;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public Node getNext(){
		return next;
	}
	public int getData(){
		return data;
	}
	public boolean isVisited(){
		return visited;
	}
	public Node createList(Node node,int data){
		try{
			if(!isVertex(node, data)){
				Node n = new Node(data);
				n.setNext(node);
				node = n;
			}
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isVertex(Node node,int data){
		try{
			Node n = node;
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