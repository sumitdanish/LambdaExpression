package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class IntersectionOfTwoSortedLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("inter.txt"));
			String[] st = sc.next().split(",");
			String[] st1 = sc.next().split(",");
			Node list1 = null;
			Node list2 = null;
			IntersectionOfTwoSortedLinkedLists in = new IntersectionOfTwoSortedLinkedLists();
			for(String s : st){
				int data = Integer.parseInt(s);
				list1 = in.createNode(list1, data);
			}
			for(String s : st1){
				int data = Integer.parseInt(s);
				list2 = in.createNode(list2, data);
			}
			in.recursion(list1, list2,Integer.MIN_VALUE,0,null);
			//in.print(dummy);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void print(Node list){
		if(list == null){
			return;
		}
		System.out.print(list.getData()+",");
		print(list.getNext());
	}
	
	private Node interSect(Node list1,Node list2,Node dummy){
		try{
			Node list11 = list1;
			Node list22 = list2;
			while(list11 != null && list2 != null){
				if(list22.getData() == list11.getData()){
					dummy = createNode(dummy,list11.getData());
					list11 = list11.getNext();
					list22 = list22.getNext();
				}else if(list11.getData() < list22.getData()){
					list11 = list11.getNext();
				}else{
					list22 = list22.getNext();
				}
			}
			return dummy;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void recursion(Node list1,Node list2,int max,int i,Node dummy){
		try{
			if(list1 == null || list2 == null){
				int l = 0;
				for(;l <= max;l++){
					System.out.print(dummy.getData()+",");
					dummy = dummy.getNext();
				}
				return;
			}
			if(list1.getData() == list2.getData()){
				if(i == 0){
					dummy = list1;
				}else{
					if(max < i){
						max = i;
					}
				}
				recursion(list1.getNext(),list2.getNext(),max,i+1,dummy);
			}else if(list1.getData() > list2.getData()){
				recursion(list1, list2.getNext(), max, i, dummy);
			}else{
				recursion(list1.getNext(), list2, max, i, dummy);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
	
	private void interSect1(Node list1,Node list2,Node dummy){
		try{
			Node list11 = list1;int len = 0;
			Node list22 = list2;int max = Integer.MIN_VALUE;
			while(list11 != null && list22 != null){
				if(list11.getData() == list22.getData()){
					if(len == 0){
						dummy = list22;
					}else{
						if(max < len){
							max = len;
						}
					}
					list11 = list11.getNext();
					list22 = list22.getNext();
					len++;
				}else if(list11.getData() < list22.getData()){
					list11 = list11.getNext();
				}else if(list11.getData() > list22.getData()){
					list22 = list22.getNext();
				}
			}
			print1(max,dummy,0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void print1(int max,Node list,int i){
		try{
			if(i>max){
				return;
			}
			System.out.print(list.getData());
			print1(max,list.getNext(),i+1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public Node createNode(Node node,int data){
		try{
			Node n = new Node(data);
			if(node == null){
				node = n;
				return node;
			}
			node.setNext(createNode(node.getNext(), data));
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
class Node
{
	private int data;
	private Node next;
	public Node(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setNext(Node next){
		this.next = next;
	}
	
	public Node getNext(){
		return next;
	}
	public int getData(){
		return data;
	}
}