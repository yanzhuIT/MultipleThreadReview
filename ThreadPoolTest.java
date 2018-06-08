import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) {
		// ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// thread changes corresponding with the task
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// create 10 task (new Runnable())
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					// each thread loop 10 times
					for (int j = 1; j <= 10; j++) {
						System.out.println(Thread.currentThread().getName() 
								+ " loop of " + j + " for task " + task);
					}
				}
			});
		}
		threadPool.shutdown();
	}
}
