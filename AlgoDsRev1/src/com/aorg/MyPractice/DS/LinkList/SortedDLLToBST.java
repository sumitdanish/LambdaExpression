package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class SortedDLLToBST {

	/**
	 * @param args
	 */
	static DLLToTree head;
	static DLLToTree previous;
	public static void main(String[] args) {
		try{
			SortedDLLToBST sort = new SortedDLLToBST();
			Scanner sc = new Scanner(new File("dlltotree.txt"));
			String[]  st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				sort.createDLLNode(data);
			}
			DLLToTree tree = sort.createTree(head,st.length-1);
			sort.printTree(tree);
			
//			sort.printNext(head);
//			System.out.println();
//			sort.printPrevious(previous);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private DLLToTree createTree(DLLToTree head,int len){
		try{
			if(head == null || len == 0){
				return null;
			}
			DLLToTree left = createTree(head,len/2);
			DLLToTree root = head;
			root.setPrevious(left);
			head = head.getNext();
			DLLToTree right = createTree(head, len - len/2-1);
			root.setNext(right);
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	private void printTree(DLLToTree dllToTree){
		if(dllToTree == null){
			return;
		}
		System.out.print(dllToTree.getData()+",");
		printTree(dllToTree.getPrevious());
		printTree(dllToTree.getNext());
		
	}
	
	
	
	
	private void createDLLNode(int data){
		DLLToTree node = new DLLToTree(data);
		if(head == null){
			head = node;
			previous = node;
		}else{
			DLLToTree temp = head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setPrevious(temp);
			previous = node;
		}
	}
	
	
	private void printNext(DLLToTree head){
		DLLToTree temp = head;
		while(temp != null){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
	}
	private void printPrevious(DLLToTree previous){
		DLLToTree pre = previous;
		while(pre != null){
			System.out.print(pre.getData()+",");
			pre = pre.getPrevious();
		}
	}
	
}
class DLLToTree
{
	private DLLToTree next;
	private DLLToTree previous;
	private int data;
	public DLLToTree(int data){
		this.data = data;
	}
	
	public void setNext(DLLToTree next){
		this.next = next;
	}
	public void setPrevious(DLLToTree previous){
		this.previous = previous;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public DLLToTree getNext(){
		return next;
	}
	public DLLToTree getPrevious(){
		return previous;
	}
}