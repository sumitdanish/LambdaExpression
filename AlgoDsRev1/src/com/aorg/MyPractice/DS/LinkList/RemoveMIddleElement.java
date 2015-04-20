package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class RemoveMIddleElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner sc = new Scanner(new File("mid.txt"));
			MidpointList list = null;
			RemoveMIddleElement re = new RemoveMIddleElement();
			while(sc.hasNext()){
				String[] s = sc.next().split(",");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				list = re.createList(x, y, list);
			}
			MidpointList list1 = re.removeDuplicate(list);
			re.print(list1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private MidpointList removeDuplicate(MidpointList list){
		try{
			if(list==null||list.getNext()==null||list.getNext().getNext()==null){
				return list;
			}
			MidpointList next = list.getNext();
			MidpointList nextOfNext = next.getNext();
			if(list.getX() == next.getX()){
				while(nextOfNext.getNext()!=null&&next.getX() == nextOfNext.getX()){
					list.setNext(next.getNext());
					next=nextOfNext;
					nextOfNext = nextOfNext.getNext();
				}
			}else if(list.getY() == next.getY()){
				while(nextOfNext.getNext()!=null&&next.getY() == nextOfNext.getY()){
					list.setNext(next.getNext());
					next=nextOfNext;
					nextOfNext = nextOfNext.getNext();
				}
			}else{
				System.out.println("List is not valid");
				return null;
			}
			removeDuplicate(list.getNext());
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	private void print(MidpointList list){
		try{
			MidpointList l = list;
			while(l!=null){
				System.out.print("("+l.getX()+","+l.getY()+")-->");
				l = l.getNext();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private MidpointList createList(int x,int y,MidpointList list){
		try{
			MidpointList node = new MidpointList(x,y);
			if(list==null){
				list = node;
				return list;
			}
			list.setNext(createList(x, y, list.getNext()));
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
class MidpointList
{
	private int x;
	private int y;
	private MidpointList next;
	public MidpointList getNext() {
		return next;
	}
	public void setNext(MidpointList next) {
		this.next = next;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public MidpointList(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	 
	
	
}