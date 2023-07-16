package exam.TEST_2022.B;

import java.util.List;

public class QueueInfo {
	int inputQueueCount;
	List<String> inputQueueURIs;
	String outputQueueURI;
	
	public int getInputQueueCount() {
		return inputQueueCount;
	}
	public void setInputQueueCount(int inputQueueCount) {
		this.inputQueueCount = inputQueueCount;
	}
	public List<String> getInputQueueURIs() {
		return inputQueueURIs;
	}
	public void setInputQueueURIs(List<String> inputQueueURIs) {
		this.inputQueueURIs = inputQueueURIs;
	}
	public String getOutputQueueURI() {
		return outputQueueURI;
	}
	public void setOutputQueueURI(String outputQueueURI) {
		this.outputQueueURI = outputQueueURI;
	}
}
