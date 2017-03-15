import java.io.*;
import java.util.*;

public class Bird implements Runnable {
	DataOutputStream d;
	Random randomGenerator;
	
    Bird (OutputStream o){
    	this.d = new DataOutputStream(o);
    	randomGenerator = new Random();
    	Thread t = new Thread(this);
    	t.start();
    }
    
	public void run() {
		try {
			while(true){
			d.writeFloat(randomGenerator.nextFloat());
			Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}