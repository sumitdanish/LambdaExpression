package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class CircularDLL {

	/**
	 * @param args
	 */
	static CDLL head;
	static CDLL pre;
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("cdll.txt"));
			CircularDLL cdll = new CircularDLL();
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				cdll.creatCircularDLL(data);
			}
			cdll.insertIntoMid(12,5);
			cdll.printCDLL();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public CircularDLL(){

	}
	
	
	private void insertIntoMid(int data,int key){
		try{
			CDLL node = new CDLL(data);
			CDLL temp = head;
			while(temp!=pre){
				if(temp.getNext().getData() == key){
					CDLL te = temp.getNext();
					node.setNext(te.getNext());
					node.setPre(te);
					te.getNext().setPre(node);
					te.setNext(node);
				}
				temp = temp.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	
	private void creatCircularDLL(int data){
		try{
			CDLL no = new CDLL(data);
			if(head == null){
				no.setNext(head);
				no.setPre(head);
				head = no;
				pre = no;
			}else{
				no.setPre(pre);
				pre.setNext(no);
				no.setNext(head);
				head.setPre(no);
				pre = no;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void printCDLL(){
		CDLL temp = head;
		while(temp != pre){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
	}
	
	
}

class CDLL
{
	private int data;
	private CDLL next;
	private CDLL pre;
	public CDLL(){
		
	}
	public CDLL(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setNext(CDLL next){
		this.next = next;
	}
	public void setPre(CDLL pre){
		this.pre = pre;
	}
	
	public int getData(){
		return data;
	}
	public CDLL getNext(){
		return next;
	}
	public CDLL getPre(){
		return pre;
	}
}
