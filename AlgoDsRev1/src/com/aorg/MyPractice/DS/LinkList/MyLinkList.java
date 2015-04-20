package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class MyLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		try{
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			sc.close();
			MyLinkList mList = new MyLinkList();
			MList list = null;
			sc = new Scanner(new File("head.txt"));
			String[] st1 = sc.next().split(",");
			for(String s:st){
				int data = Integer.parseInt(s);
				list = mList.createList(data,list);
			}
			//list = mList.addIntoHead(list,123);
			for(String s : st1){
				int data = Integer.parseInt(s);
				list = mList.addIntoHead(list, data);
			}
			mList.printList(list);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private MList createList(int data,MList next){
		try{
			MList list = new MList(data);
			if(next==null){
				next = list;
				return next;
			}
			next.setNext(createList(data, next.getNext()));
			//printList(next);
			return next;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void printList(MList mList){
		try{
			MList list = mList;
			while(list!=null){
				System.out.print(list.getData()+",");
				list = list.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private MList addIntoHead(MList list,int data){
		try{
			MList headList = new MList(data);
			headList.setNext(list);
			//list = headList;
			return headList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
}
