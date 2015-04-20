package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class ReverseDoublyLinkList {

	/**
	 * @param args
	 */
	static RevDLL head;
	static RevDLL prev;
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("list.txt"));
			ReverseDoublyLinkList rev = new ReverseDoublyLinkList();
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				rev.createDLL(data);
			}
			rev.reverserDLL();
			rev.printNext();
			System.out.println();
			rev.printPrev();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void reverserDLL(){
		try{
			RevDLL te = head;
			head = prev;
			prev = te;
			RevDLL temp1 = head;
			while(temp1 !=null){
				te = temp1.getNext();
				temp1.setNext(temp1.getPrev());
				temp1.setPrev(te);
				temp1 = temp1.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	
	private void printPrev(){
		try{
			RevDLL pre = prev;
			while(pre != null){
				System.out.print(pre.getData()+",");
				pre = pre.getPrev();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void printNext(){
		try{
			RevDLL temp = head;
			while(temp != null){
				System.out.print(temp.getData()+",");
				temp = temp.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void createDLL(int data){
		try{
			RevDLL rev = new RevDLL(data);
			if(head == null){
				rev.setPrev(null);
				rev.setNext(head);
				head = rev;
				prev = rev;
			}else{
				RevDLL re = head;
				while(re.getNext() != null){
					re = re.getNext();
				}
				re.setNext(rev);
				rev.setPrev(re);
				rev.setNext(null);
				prev = rev;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
class RevDLL
{
	private int data;
	private RevDLL next;
	private RevDLL prev;
	public RevDLL(int data){
		this.data = data;
	}
	
	public void setNext(RevDLL next){
		this.next = next;
	}
	public void setPrev(RevDLL pre){
		this.prev = pre;
	}
	public void setData(int data){
		this.data = data;
	}
	public RevDLL getNext(){
		return next;
	}
	public RevDLL getPrev(){
		return prev;
	}
	public int getData(){
		return data;
	}
	
	
}