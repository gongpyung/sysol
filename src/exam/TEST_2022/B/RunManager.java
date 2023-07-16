package exam.TEST_2022.B;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpMethod;

import exam.spUtil;

public class RunManager {

	static QueueInfo queueInfo = getQueueInfo();
	static List<Worker> workerList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		for (int i=0; i<queueInfo.getInputQueueCount(); i++) {
			workerList.add(new Worker(i));
		}
		
		ExecutorService service = Executors.newFixedThreadPool(queueInfo.getInputQueueCount());
		for (int i=0; i<queueInfo.getInputQueueCount(); i++) {
			String inputURI = queueInfo.getInputQueueURIs().get(i);
			int idx = i;
			service.execute(() -> {
				while (true) {
					System.out.println("Worker No : " + idx + " URI : " + inputURI);
					Input inputInfo = getNextInfo(inputURI);
					// String output = workerList.get(idx).run(inputInfo.getTimestamp(), inputInfo.getValue());
					// if (!spUtil.isNullOrEmpty(output)) sendOutput(output);
				}
			});
		}
	}
	
	private static void sendOutput(String output) {
		HttpClient httpClient = new HttpClient();
		try {
			httpClient.start();
			HashMap<String, String> res = new HashMap<>();
			res.put("result", output);
			
			String resJson = spUtil.ObjectToJsonString(res);
			System.out.println("res : " + resJson);
			ContentResponse contentRes = httpClient.newRequest(queueInfo.getOutputQueueURI()).method(HttpMethod.POST).content(new StringContentProvider(resJson)).send();
			httpClient.stop();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Input getNextInfo(String inputURI) {
		HttpClient httpClient = new HttpClient();
		try {
			httpClient.start();
			ContentResponse contentRes = httpClient.newRequest(inputURI).method(HttpMethod.GET).send();
			System.out.println("contentRes.getContentAsString() : " + contentRes.getContentAsString());
			httpClient.stop();
			
			Input input = spUtil.stringToObject(contentRes.getContentAsString(), Input.class);
			return input;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static QueueInfo getQueueInfo() {
		HttpClient httpClient = new HttpClient();
		try {
			httpClient.start();
			ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/queueInfo").method(HttpMethod.GET).send();
			System.out.println("contentRes.getContentAsString() : " + contentRes.getContentAsString());
			httpClient.stop();
			
			QueueInfo queueInfo = spUtil.stringToObject(contentRes.getContentAsString(), QueueInfo.class);
			return queueInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}