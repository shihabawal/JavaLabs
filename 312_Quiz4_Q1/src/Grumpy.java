import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Grumpy implements Runnable,Serializable {

	private Thread t;
	ObjectOutputStream oos;
	int count;
	
	public static void main (String[] args) throws IOException{
		Grumpy g = new Grumpy(System.out);
		System.out.println("");
	}

	public Grumpy(OutputStream os) throws IOException {
		t = new Thread(this);
		t.start();
		oos = new ObjectOutputStream(os);
		count++;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			oos.writeObject(this);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
