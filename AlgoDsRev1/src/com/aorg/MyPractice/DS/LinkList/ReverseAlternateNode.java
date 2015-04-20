package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class ReverseAlternateNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc =new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			MList list = null;
			ReverseAlternateNode re = new ReverseAlternateNode();
			for(String s : st){
				int data = Integer.parseInt(s);
				list = re.createList(list, data);
			}
			re.print(list);
			System.out.println();
			re.swap1(list);
			re.print(list);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void print(MList list){
		try{
			MList head = list;
			while(head!=null){
				System.out.print(head.getData()+",");
				head = head.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private MList swapPairwise(MList head){
		try{
			MList pre = head;
			MList cur = head.getNext();
			MList head1 = cur;
			while(true){
				MList l1 = cur.getNext();
				cur.setNext(pre);
				if(l1==null||l1.getNext()==null){
					pre.setNext(l1);;
					break;
				}
				pre.setNext(l1.getNext());
				pre = l1;
				cur = pre.getNext();
			}
			return head1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private MList createList(MList list,int data){
		try{
			MList ml = new MList(data);
			if(list==null){
				list = ml;
				return list;
			}
			list.setNext(createList(list.getNext(),data));
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private MList swap1(MList list){
		try{
			if(list==null||list.getNext()==null){
				return list;
			}
			MList remaing = list.getNext().getNext();
			MList newHead = list.getNext();
			list.getNext().setNext(list);
			list.setNext(swap1(remaing));
			return newHead;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
}
