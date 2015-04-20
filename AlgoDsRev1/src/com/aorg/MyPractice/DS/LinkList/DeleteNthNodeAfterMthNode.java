package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class DeleteNthNodeAfterMthNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			DeleteNthNodeAfterMthNode se = new DeleteNthNodeAfterMthNode();
			MList head = null;
			int n=3;
			int m=2;
			for(String s : st){
				int data = Integer.parseInt(s);
				head = se.createList(head, data);
			}
			//se.print(head);
			head = se.linkList(head, n, m);
			se.print(head);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private MList linkList(MList head,int n,int m){
		try{
			MList list = head;
			MList list4 = head;
			MList list3 = null;
			while(list!=null){
				//MList list1 = list;
				for(int i=1;i<m && list!=null;i++){
					list = list.getNext();
				}
				if(list == null){
					return head;
				}
				list3 = list.getNext();
				for(int j = 0;j<n && list3!=null;j++){
					list3 = list3.getNext();
				}
				list.setNext(list3);
				//list1 = list2;
				list = list3;
			}
			return list4;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private MList createList(MList head,int data){
		try{
			MList node = new MList(data);
			if(head == null){
				head = node;
				return head;
			}
			head.setNext(createList(head.getNext(), data));
			return head;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void print(MList head){
		try{
			MList h = head;
			while(h!=null){
				System.out.print(h.getData()+",");
				h = h.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
