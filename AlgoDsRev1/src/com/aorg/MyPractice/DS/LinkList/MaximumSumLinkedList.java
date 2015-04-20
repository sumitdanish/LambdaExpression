package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

import sun.font.CreatedFontTracker;

public class MaximumSumLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			MaximumSumLinkedList maxList = new MaximumSumLinkedList();
			MList list1 = null;
			MList list2 = null;
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			String[] st2 = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				list1 = maxList.createList(list1, data);
			}
			for(String s : st2){
				int data = Integer.parseInt(s);
				list2 = maxList.createList(list2, data);
			}
			
			MList head = maxList.getMaxSumList(list1, list2);
			maxList.printList(head);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private MList getMaxSumList(MList list1,MList list2){
		try{
			MList result = null;
			MList list11 = list1;
			MList list22 = list2;
			MList list111 = list11;
			MList list222 = list22;
			while(list111!=null||list222!=null){
				int sum1 = 0;
				int sum2 = 0;
				while(list111!=null&&list222!=null){
					if(list111.getData()<list222.getData()){
						sum1+=list111.getData();
						list111 = list111.getNext();
					}else{
						sum2+=list222.getData();
						list222 = list222.getNext();
					}
				}
				if(list111 == null){
					while(list222!=null){
						sum2+=list222.getData();
						list222 = list222.getNext();
					}
				}
				if(list222!=null){
					while(list111!=null){
						sum1+=list111.getData();
						list111 = list111.getNext();
					}
				}
				if(list11 == list1&&list22 == list2){
					result = sum1>sum2?list11:list22;
				}else{
					if(sum1>sum2){
						list22.setNext(list11.getNext());
					}else {
						list11.setNext(list22.getNext());
					}
				}
				list11 = list111;
				list22 = list222;
				if(list111!=null){
					list111 = list111.getNext();
				}
				if(list222!=null){
					list222 = list222.getNext();
				}
			}
			return result;
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
