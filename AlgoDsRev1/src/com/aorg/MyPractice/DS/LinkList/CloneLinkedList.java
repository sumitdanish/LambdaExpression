package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class CloneLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("list.txt"));
			MList list = null;
			CloneLinkedList cl = new CloneLinkedList();
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				list = cl.createList(data, list);
			}
			MList list1 = cl.copyList(list);
			cl.printList(list1);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}

	}

	
	private MList copyList(MList list){
		try{
			MList nList = list;
			MList copyList = nList;
			MList temp = null;
			MList temp1 = list.getNext();
			while(temp1!=null){
				temp = new MList(list.getData());
				list.setNext(temp);
				temp.setNext(temp1);
				temp = temp1;
				list = temp;
				temp1 = list.getNext();
			}
			return nList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private MList createList(int data,MList list){
		try{
			MList node = new MList(data);
			if(list==null){
				list = node;
				return list;
			}
			list.setNext(createList(data, list.getNext()));
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void printList(MList list){
		try{
			MList n = list;
			while(n!=null){
				System.out.print(n.getData()+",");
				n = n.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
