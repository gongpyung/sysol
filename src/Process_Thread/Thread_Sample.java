package Process_Thread;

public class Thread_Sample {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is running.....");
			}
		});
		
		t1.start();
		
		Runnable taskR = () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		};
		new Thread(taskR).start();
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		}).start();
	}
}