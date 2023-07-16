package edu.Process_Thread;

class ThreadClass2T implements Runnable {
	public void run() {
		System.out.println("Thread is running.......");
	}
}

public class Thread_Implements {

	public static void main(String[] args) {
		ThreadClass2T m1 = new ThreadClass2T();
		Thread t1 = new Thread(m1);
		t1.start();
	}
}