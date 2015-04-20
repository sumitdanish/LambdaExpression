package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;


public class DLLOperation {

	/**
	 * @param args
	 */
	
	static DLLOpe head;
	static DLLOpe pre;
	public static void main(String[] args) {
		try{
			DLLOperation dll = new DLLOperation();
			Scanner sc = new Scanner(new File("dlltotree.txt"));
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				dll.create(data);
			}
			dll.deleteNode(4);
			dll.insertIntoEnd(19);
			dll.printNext(head);
			System.out.println();
			dll.printPre(pre);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	
	private void deleteNode(int data){
		try{
			DLLOpe temp = head;
			if(temp.getData() == data){
				DLLOpe te = temp.getNext();
				head = te;
				temp = null;
			}else{
				while(temp != null){
					if(temp.getNext() != null && temp.getNext().getNext() != null && temp.getNext().getData() == data){
						DLLOpe temp1 = temp;
						DLLOpe temp2 = temp.getNext();
						DLLOpe temp3 = temp2.getNext();
						temp1.setNext(temp3);
						temp3.setPrevious(temp1);
						temp2 = null;
					}else if(temp.getNext() != null && temp.getNext().getData() == data && temp.getNext().getNext() == null){
						DLLOpe te = temp.getNext();
						temp.setNext(null);
						pre = temp;
						te = null;
					}
					temp = temp.getNext();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void insertIntoEnd(int data){
		try{
			DLLOpe nod = new DLLOpe(data);
			if(head == null){
				head = nod;
				pre = nod;
			}else{
				nod.setPrevious(pre);
				pre.setNext(nod);
				pre= nod;
				nod.setNext(null);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void insertIntoMid(int data,int key){
		try{
			DLLOpe op = new DLLOpe(data);
			DLLOpe temp = head;
			while(temp != null && temp.getNext() != null){
				if(temp.getNext().getData() == key){
					DLLOpe tem = temp.getNext().getNext();
					temp.getNext().setNext(op);
					temp.getNext().getNext().setPrevious(temp.getNext());
					op.setNext(tem);
					tem.setPrevious(op);
				}
				temp = temp.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private void insertIntoHead(int data){
		try{
			DLLOpe node = new DLLOpe(data);
			if(head == null){
				head = node;
				pre = node;
			}else{
				node.setNext(head);
				head.setPrevious(node);
				head = node;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
	
	
	
	
	private void printPre(DLLOpe node){
		try{
			DLLOpe no = node;
			while(no != null){
				System.out.print(no.getData()+",");
				no = no.getPrevious();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void printNext(DLLOpe node){
		try{
			DLLOpe n = node;
			while(n != null){
				System.out.print(n.getData()+",");
				n = n.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private void create(int data){
		try{
			DLLOpe node = new DLLOpe(data);
			if(head == null){
				head = node;
				pre = node;
			}else{
				DLLOpe n = head;
				while(n.getNext() != null){
					n = n.getNext();
				}
				n.setNext(node);
				node.setPrevious(n);
				pre = node;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

class DLLOpe
{
	private int data;
	private DLLOpe next;
	private DLLOpe previous;
	
	public DLLOpe(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setNext(DLLOpe next){
		this.next = next;
	}
	public void setPrevious(DLLOpe previous){
		this.previous = previous;
	}
	
	public int getData(){
		return data;
	}
	public DLLOpe getNext(){
		return next;
	}
	public DLLOpe getPrevious(){
		return previous;
	}
}
