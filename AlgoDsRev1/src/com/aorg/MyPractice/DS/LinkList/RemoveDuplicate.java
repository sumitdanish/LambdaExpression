package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			RemoveDuplicate re = new RemoveDuplicate();
			RemoveDup list = null;
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			for(String s : st){
				int data =Integer.parseInt(s);
				list = re.createList(list, data);
			}
			re.print(list);
			System.out.print("\n");
			re.removeDup(list);
			re.print(list);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	private void print(RemoveDup list){
		try{
			RemoveDup temp = list;
			while(temp != null){
				System.out.print(temp.getData()+",");
				temp = temp.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void removeDup(RemoveDup list){
		try{
			RemoveDup tempList = list;
			RemoveDup tempList1 = null;
			while(tempList != null){
				tempList1 = tempList;
				while(tempList1.getNext() != null){
					if(tempList.getData() == tempList1.getNext().getData()){
						RemoveDup temp = tempList1.getNext();
						temp = null;
						tempList1.setNext(tempList1.getNext().getNext());
					}else{
						tempList1 = tempList1.getNext();
					}
				}
				tempList = tempList.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private RemoveDup createList(RemoveDup list,int data){
		try{
			RemoveDup node = new RemoveDup(data);
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
}
class RemoveDup
{
	private int data;
	private RemoveDup next;
	public RemoveDup(int data){
		this.data = data;
	}
	public void setNext(RemoveDup next){
		this.next = next;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public RemoveDup getNext(){
		return next;
	}
}