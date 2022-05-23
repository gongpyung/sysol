package Process_Thread;

public class Thread_Practice1 {

	public static void main(String[] args) throws InterruptedException {
		ThreadClass th1 = new ThreadClass("Thread1");
		ThreadClass th2 = new ThreadClass("Thread2");
		
		th1.start();
		th2.start();
		
		for (int i=0; i<10; i++) {
			System.out.println("[Main] " + i);
//			Thread.sleep(10);
		}
		th1.join();
		th2.join();
	}
}

class ThreadClass extends Thread {
	String thread_name;
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("[" + thread_name + "] " +  i);
		}
		try {
			sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
