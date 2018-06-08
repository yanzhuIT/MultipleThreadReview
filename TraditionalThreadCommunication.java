
public class TraditionalThreadCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {

			@Override
			public void run() {
					for (int i = 1; i <= 20; i++) {
						business.sub(i);
				}
			}
		}).start();
		
			for (int i = 1; i <= 20; i++) {
				business.main(i);
		}
	}
}

class Business {
	private boolean sub = true;
	public synchronized void sub(int i) {
		while (!sub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread sequence " + j + "  loop " + i);
		}
		sub = false;
		this.notify();
	}

	public synchronized void main(int i) {
		while (sub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("main thread sequence " + j + "  loop " + i);
		}
		sub = true;
		this.notify();
	}
}
