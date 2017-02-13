package com.test;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

	private static String name="11";
	
	public static void main(String[] args) {
//		ThreadA ta=new ThreadA(name);
//		Thread t1= new Thread(ta);
//		t1.start();
//		
//		ThreadB tb=new ThreadB(name);
//		Thread t2= new Thread(tb);
//		t2.start();
		
		List<String> list = new ArrayList<String>();
		if(list.isEmpty()){
			System.out.println("list是空的");
		}
		Device d = Device.Others;
	}

}

class Sync{
	
	private static int num =0;
	public static void add(){
		System.out.println(Thread.currentThread().getName());
		synchronized (Sync.class) {
			num++;
			System.out.println(num);
		}
	}
}

class SyncUtil {
	private static Sync sync= null;
	private SyncUtil(){
		
	}
	public Sync getInstance(){
		if(sync ==null){
			synchronized (SyncUtil.class) {
				if(sync==null){
					sync = new Sync();
				}
			}
		}
		return sync;
	}
}

class ThreadA implements Runnable{
	private String name;
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			
			Sync.add();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public ThreadA(String name){
		this.name = name;
	}
}

class ThreadB implements Runnable{
	private String name;
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Sync.add();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public ThreadB(String name){
		this.name = name;
	}
}
enum Device{
	Phone,Tablet,TV,Others;
	
}
