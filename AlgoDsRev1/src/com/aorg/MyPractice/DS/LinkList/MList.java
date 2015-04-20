package com.aorg.MyPractice.DS.LinkList;

public class MList
{
	private int data;
	private MList next;
	public MList(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public void setNext(MList next){
		this.next = next;
	}
	public MList getNext(){
		return next;
	}
}