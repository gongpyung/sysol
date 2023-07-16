package exam.TEST_2022.B;

import java.util.List;

public class Worker {
	int queueNo;
	
	public Worker(int queueNo) {
		this.queueNo = queueNo;
	}
	
	public void removeExpiredStoreItems(long timestamp, List<String> store) {
		store.stream().filter(value -> {
			Long inputTimeStamp = Long.valueOf(value.split("#")[0]);
			if (timestamp - inputTimeStamp > 3000) {
				return true;
			}
			return false;
		}).forEach(value -> store.remove(value));
	}
}
