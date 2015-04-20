package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;



public class DivideSinglyCircularLinkList {

	/**
	 * @param args
	 */
	static CirSLL list;
	public static void main(String[] args) {
		try{
			DivideSinglyCircularLinkList di = new DivideSinglyCircularLinkList();
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				di.createCirSLL(data);
			}
			di.print(list);
			System.out.println();
			di.splitCircularList();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public DivideSinglyCircularLinkList(){
		//list = new CirSLL();
	}
	
	
	public void print(CirSLL list){
		try{
			CirSLL head = list;
			while(head != null){
				System.out.print(head.getData()+",");
				head = head.getNext();
				if(head == list){
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void splitCircularList(){
		try{
			CirSLL slowPointer = list;
			CirSLL fastPointer = list;
			CirSLL sp = slowPointer;
			CirSLL fp = fastPointer;
			while(slowPointer !=null && fastPointer !=null){
				fastPointer = fastPointer.getNext();
				if(fastPointer.getNext() != list){
					slowPointer = slowPointer.getNext();
					fastPointer = fastPointer.getNext();
				}else{
					fp = slowPointer.getNext();
					slowPointer.setNext(list);
					fastPointer.setNext(fp);
					break;
				}
			}
			print(sp);
			System.out.println();
			print(fp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void createCirSLL(int data){
		try{
			CirSLL head = list;
			CirSLL node = new CirSLL(data);
			if(list == null){
				node.setNext(node);
				list = node;
			}else{
				while(head.getNext() != list){
					head = head.getNext();
				}
				node.setNext(list);
				head.setNext(node);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
class CirSLL
{
	private int data;
	private CirSLL next;
	public CirSLL(){
		
	}
	public CirSLL(int data){
		super();
		this.data = data;
		
	}
	public void setNext(CirSLL next){
		this.next = next;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public CirSLL getNext(){
		return next;
	}
}