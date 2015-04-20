package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class MergeTwoListInAlternatePosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			MergeTwoListInAlternatePosition mer = new MergeTwoListInAlternatePosition();
			MList list1 = null;
			MList list2 = null;
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			String[] st2 = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				list1 = mer.createList(list1, data);
			}
			for(String s : st2){
				int data = Integer.parseInt(s);
				list2 = mer.createList(list2, data);
			}
			MList head=mer.mergeList(list1, list2);
			mer.printList(head);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private MList mergeList(MList list1,MList list2){
		try{
			
			MList pre1 = list1;
			MList head = pre1;
			MList pre2 = list2;
			MList pre1_1 = null;
			MList pre2_2 = null;
			while(pre1!=null&&pre2!=null){
				pre1_1= pre1.getNext();
				pre2_2= pre2.getNext();
				pre1.setNext(pre2);
				pre2.setNext(pre1_1);
				pre1 = pre1_1;
				pre2 = pre2_2;
			}
			if(pre2!=null){
				MList temp =head;
				MList temp1 =temp;
				while(temp1!=null&&temp1.getNext()!=null){
					temp1 = temp1.getNext();
				}
				temp1.setNext(pre2);
				temp1 = pre2;
			}else if(pre1!=null){
				MList temp =head;
				MList temp1 =temp;
				while(temp1!=null&&temp1.getNext()!=null){
					temp1 = temp1.getNext();
				}
				temp1.setNext(pre1);
				temp1 = pre1;
			}
			
			return head;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private MList createList(MList list,int data){
		try{
			MList node = new MList(data);
			if(list == null){
				list = node;
				return list;
			}
			list.setNext(createList(list.getNext(), data));
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void printList(MList list){
		try{
			MList li = list;
			while(li!=null){
				System.out.print(li.getData()+",");
				li = li.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
