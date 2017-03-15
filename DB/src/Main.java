import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		try {
			/*Socket client = new Socket("www.aosoble.com", 5984);
			System.out.println(client.getRemoteSocketAddress());
			OutputStream o = client.getOutputStream();
			o.write("GET /keystrokes \r\n\r\n".getBytes());
			InputStream i = client.getInputStream();
			while (i.available() == 0);
			System.out.println(i.available());

			while (i.available() != 0) {
				System.out.write(i.read());
			}
			client.close();*/
			
			Socket client = new Socket("www.aosoble.com", 5984); 
			OutputStream o = client.getOutputStream();
			InputStream i = client.getInputStream();
			o.write("GET /keystrokes/48715 \r\n\r\n".getBytes());
			while (i.available() == 0);
			//System.out.println(i.available());
			Reader r = new Reader(p);
			r.read(i);
			
			//===========================================================================================
			//======================================GERMAN's code  start=================================
			//===========================================================================================
			//sample code below (uncomment to see how things work)
			for (int k=0; k<p.trials.length; k++){
				for (int x=0; x<p.trials[k].words.length; x++){
					//String let = p.trials[k].words[x].letter.toString();
					String pre = p.trials[k].words[x].pressed.toString();
					String rel = p.trials[k].words[x].released.toString();
					//double pre = Double.parseDouble(p.trials[k].words[x].pressed.toString());
					//double rel = Double.parseDouble(p.trials[k].words[x].released.toString());
					System.out.print(rel  + ",");
				}
				System.out.println("");
			}

			//===========================================================================================
			//======================================GERMAN's code  end===================================
			//===========================================================================================
			
			Thread.sleep(500);
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
