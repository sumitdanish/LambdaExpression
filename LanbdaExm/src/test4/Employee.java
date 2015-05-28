package test4;

import java.awt.List;
import java.util.ArrayList;

public class Employee {

	private String id;
	private String fName;
	private String lName;
	private ArrayList<Employee> list;
	public Employee(String id,String fName,String lName){
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	
	public ArrayList<Employee> getList() {
		return list;
	}
	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString(){
		return "ID : "+id+"First Name : "+fName+"\n Last Name "+lName+"\n";
	}
	
}
