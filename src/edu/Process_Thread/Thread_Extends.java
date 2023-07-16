package edu.Process_Thread;

class ThreadClassT extends Thread {
	// Thread�� ����Ǹ� run() ȣ��
	public void run() {
		System.out.println("Thread is started");
		try {
			// join()�� ȣ���ϴ� Thread�� ������ ��ٷ� ������� ���°� �� ���� ����.
			// �׷��� sleep�� ���� ���� �ð� ��ٸ� �� ������� �ʾ��� �� �������� �ٸ� �۾��� ������.
			Thread.sleep(10000); // ���� : ms
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread is exiting");
	}
}
public class Thread_Extends {
	public static void main(String[] args) {
		ThreadClassT tc1 = new ThreadClassT();
		// main�� ThreadClass��� �ΰ��� �����尡 ���ÿ� ����
		tc1.start();
		try {
			// ThreadClass�� ����� ������ ��ٸ���.
			tc1.join();
			// ������ ��ٸ��Ƿ� 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
