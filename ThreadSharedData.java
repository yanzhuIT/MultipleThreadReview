import java.util.Random;

public class ThreadSharedData {
	private static ThreadLocal<Integer> xLocal = new ThreadLocal<>();
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + "  " + data);
					xLocal.set(data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
			int data = xLocal.get();
			System.out.println("   A   " + Thread.currentThread().getName() + "  " + data);
		}
	}

	static class B {
		public void get() {
			int data = xLocal.get();
			System.out.println("   B   " + Thread.currentThread().getName() + "  " + data);
		}
	}
}

class MyData{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	
}
