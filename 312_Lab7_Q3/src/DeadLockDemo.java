import java.util.*;

public class DeadLockDemo extends Thread {
	public static String jar1 = "ESPRESSO";
	public static String jar2 = "LATTE";

	public static void main(String[] a) {
		Thread ahmad = new Ahmad();
		Thread ali = new Ali();

		ahmad.start();
		ali.start();
	}

	private static class Ahmad extends Thread {
		public void run() {
			synchronized (jar1) {
				System.out.println("Ahmad grabs jar1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}

				System.out.println("Ahmad  waiting for jar2");
				synchronized (jar2) {
					System.out
							.println("Ahamd grabs both jar1 and jar2 and enjoys coffee");
				}
			}
		}
	}

	private static class Ali extends Thread {
		public void run() {
			synchronized (jar1) {
				System.out.println("Ali grabs jar1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Ali waiting jar2");
				synchronized (jar2) {
					System.out
							.println("Ali grabs both jar1 and jar2 and enjoys coffee");
				}
			}
		}
	}
}