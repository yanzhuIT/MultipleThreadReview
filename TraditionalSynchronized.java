
public class TraditionalSynchronized {
	public static void main(String[] args) {
		new TraditionalSynchronized().init();
	}
	
	private void init() {
		Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("zhu");
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output2("yan");
				}
			}
		}).start();
	}
	static class Outputer{
		public void output(String name) {
			int length = name.length();
			synchronized (this) {
				for(int i = 0; i < length; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public synchronized void output2(String name) {
			int length = name.length();
				for(int i = 0; i < length; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
		
		public static synchronized void output3(String name) {
			int length = name.length();
				for(int i = 0; i < length; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
		public void output4(String name) {
			int length = name.length();
			synchronized (Outputer.class) {
				for(int i = 0; i < length; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}
}
