package edu.DataStructure;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_Sample {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		q.add("one");
		q.add("two");
		q.add("three");
		
		System.out.println("Queue Count = " + q.size());
		
		for (String number : q) System.out.println(number);
		
		System.out.println("Deque : " + q.poll());
		System.out.println("Peek : " + q.peek());
		System.out.println("Contains(\"three\") : " +q.contains("three"));
		
		q.clear();
		System.out.println("Queue Cont = " + q.size());
	}
}