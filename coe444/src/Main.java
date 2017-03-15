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
			DataAnalyzer dataanalyzer = new DataAnalyzer ();
			double [] [] previousinputs = new double [43] [14];
			double [] timesofpressing = new double [43], timesofreleasing = new double [43];
			int index, index1, index2;
			Socket client;
			String [] ids = new String [] {"47562", "48546", "48715", "50113", "56902", "61095"};
			OutputStream o;
			InputStream i;
			for (index = 0; index < ids.length; index = index + 1)
			{
				client = new Socket("www.aosoble.com", 5984); 
				o = client.getOutputStream();
				i = client.getInputStream();
				o.write(("GET /keystrokes/" + ids [index] + " \r\n\r\n").getBytes());
				while (i.available() == 0);
				Reader r = new Reader(p);
				r.read(i);
				for (int k=0; k<p.trials.length; k++){
					for (int x=0; x<p.trials[k].words.length; x++){
						String let = p.trials[k].words[x].letter.toString();
						String pre = p.trials[k].words[x].pressed.toString();
						String rel = p.trials[k].words[x].released.toString();
						System.out.print(let + " " + pre  + " " + rel  + "\t");
					}
					System.out.println("");
				}
				for (index1 = 0; index1 < 14; index1 = index1 + 1)
				{
					for (index2 = 0; index2 < 43; index2 = index2 + 1)
					{
						previousinputs [index2] [index1] = (double) p.trials [index1].words [index2].released - (double) p.trials [index1].words [index2].pressed;
					}
				}
				for (index1 = 0; index1 < 43; index1 = index1 + 1)
				{
					timesofpressing [index1] = p.trials [10].words [index1].pressed;
				}
				for (index1 = 0; index1 < 43; index1 = index1 + 1)
				{
					timesofreleasing [index1] = p.trials [10].words [index1].released;
				}
				dataanalyzer.SetPreviousInputs (previousinputs);
				dataanalyzer.SetTimesOfPressing (timesofpressing);
				dataanalyzer.SetTimesOfReleasing (timesofreleasing);
				System.out.println (dataanalyzer.AcceptResults ("Eucledian Distance"));
				System.out.println (dataanalyzer.AcceptResults ("Normed Eucledian Distance"));
				System.out.println (dataanalyzer.AcceptResults ("Manhattan Distance"));
				System.out.println (dataanalyzer.AcceptResults ("Manhattan Scaled Distance"));
				System.out.println (dataanalyzer.AcceptResults ("Mahalanobis Distance"));
				Thread.sleep(500);
				client.close();
			}
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