package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Queue_Practice {

	static HashMap<String, MsgQueue> queues;
	static MsgQueue mq;
	
	public static void main(String[] args) throws IOException {
		System.out.println("START!!!");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] input;
		queues = new HashMap<String, MsgQueue>();
		
		while (true) {
			line = br.readLine();
			input = line.split(" ");
			
			switch (input[0]) {
			case "CREATE" :
				System.out.println(QCreate(input[1], Integer.parseInt(input[2])));
				break;
			case "ENQUEUE" :
				System.out.println(QEnqueue(input[1], input[2]));
				break;
			case "DEQUEUE" :
				System.out.println(QDequeue(input[1]));
				break;
			case "GET" :
				System.out.println(QGet(input[1]));
				break;
			case "SET" :
				System.out.println(QSet(input[1], Integer.parseInt(input[2])));
				break;
			case "DEL" :
				System.out.println(QDel(input[1], Integer.parseInt(input[2])));
				break;
			case "QUIT" :
				br.close();
				System.out.println("END!!!");
				return ;
			default :
				break;
			}
		}
	}
	
	static String QCreate(String name, int size) {
		
		if (queues.containsKey(name)) return "Queue Exist";
		else {
			MsgQueue q = new MsgQueue(size);
			queues.put(name, q);
			return "Queue Created";
		}
	}
	
	static String QEnqueue(String name, String message) {
		return queues.get(name).MsgEnqueue(message);
	}
	
	static String QDequeue(String name) {
		return queues.get(name).MsgDequeue();
	}
	
	static String QGet(String name) {
		return queues.get(name).MsgGet();
	}

	static String QSet(String name, int key) {
		return queues.get(name).MsgSet(key);
	}
	
	static String QDel(String name, int key) {
		return queues.get(name).MsgDel(key);
	}
}

class MsgQueue {
	private int seqNo;
	private int size;
	
	// List - (status, msg)
	private HashMap<Integer, List<String>> hashMsg;

	public MsgQueue(int size) {
		this.size = size;
		this.seqNo = 0;
		hashMsg = new HashMap<Integer, List<String>>();
	}
	
	public String MsgEnqueue(String message) {
		
		if (hashMsg.size() == size) return "Queue Full";
		else {
			List<String> listMsg = new ArrayList<String>();
			listMsg.add("A");
			listMsg.add(message);
			
			hashMsg.put(seqNo++, listMsg);
			return "Enqueued";
		}
	}
	
	public String MsgDequeue() {
		if (hashMsg.size() == 0) return "Queue Empty";
		else {
			int key = hashMsg.keySet().iterator().next();
			String res = hashMsg.get(key).get(1) + "(" + key + ")";
			hashMsg.remove(key);
			return res;
		}
	}
	
	public String MsgGet() {
		if (hashMsg.size() > 0) {
			for (Integer key : hashMsg.keySet()) {
				if (hashMsg.get(key).get(0).equals("A")) {
					String res = hashMsg.get(key).get(1) + "(" + key + ")";
					List<String> val = hashMsg.get(key);
					val.set(0, "C");
					hashMsg.put(key, val);
					return res;
				}
			}
		}
		return "No Msg";
	}
	
	public String MsgSet(int key) {
		if (hashMsg.containsKey(key)) {
			List<String> val = hashMsg.get(key);
			val.set(0, "A");
			hashMsg.put(key, val);
			return "Msg Set";
		}
		return "Set Fail";
	}
	
	public String MsgDel(int key) {
		if (hashMsg.containsKey(key)) {
			hashMsg.remove(key);
			return "Deleted";
		}
		return "Not Deleted";
	}
}