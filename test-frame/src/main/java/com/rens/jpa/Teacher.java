package com.rens.jpa;

public class Teacher extends Person {
	public int b;
	
	public void printValue(){
		System.out.println("Teacher printValue()");
	}
//	public void printValue(int i){
//		System.out.println("Teacher printValue(int i)");
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person p = new Person();
//		Teacher t = new Teacher();
//		int i;
//		i=p.change(30);
//		i=t.b;
		
		Person t= new Teacher();
		t.printValue(10);
	}

}
class Person{
	private int a;
	public int change(int m){
		return m;
	}
	
	public void printValue(int i,int t){
		System.out.println("printValue(int i,int t)");
	}
	public void printValue(int i){
		System.out.println("printValue(int i)");
	}
}
