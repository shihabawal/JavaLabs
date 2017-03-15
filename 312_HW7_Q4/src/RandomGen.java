import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class RandomGen implements Runnable, Serializable{

	transient private Thread t;
	private int num;
	transient private String name;
	
	public RandomGen(String name){
		num = 0;
		this.name = name;
		Operation();
	}
	
	private void Operation(){
		System.out.println("New thread is created and started after reading the object from the file");
		t = new Thread(this);
		t.setName(name);
		t.start();
	}
	
	public void writeObject(ObjectOutputStream out) throws IOException{
		out.writeInt(num);
	}
	
	public void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException{
		num = in.readInt();
		Operation();
	}
	
	public void run() {
		while (true){
			Random r = new Random();
			this.num = r.nextInt(10) + 1;
			System.out.println(t.getName() + " generated " + num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
