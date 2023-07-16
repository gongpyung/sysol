package edu.Process_Thread;

class ThreadClassT extends Thread {
	// Thread가 실행되면 run() 호출
	public void run() {
		System.out.println("Thread is started");
		try {
			// join()을 호출하는 Thread는 무한히 기다려 응답없는 상태가 될 수도 있음.
			// 그래서 sleep을 통해 일정 시간 기다린 후 종료되지 않았을 때 빠져나와 다른 작업을 진행함.
			Thread.sleep(10000); // 단위 : ms
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread is exiting");
	}
}
public class Thread_Extends {
	public static void main(String[] args) {
		ThreadClassT tc1 = new ThreadClassT();
		// main과 ThreadClass라는 두개의 쓰레드가 동시에 실행
		tc1.start();
		try {
			// ThreadClass가 종료될 때까지 기다린다.
			tc1.join();
			// 무한히 기다리므로 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
