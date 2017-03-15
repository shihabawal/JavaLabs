import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	private Person p;

	public Reader(Person p){
		this.p = p;
	}
	
	public void read(InputStream in) throws IOException {
		int i=0, j=0;
		String data = new String("");
		while (in.read() != '{');
		data = "{";
		while (in.available() != 0) {
			data += (char)in.read();
		}
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(data);
			JSONObject jobj = (JSONObject)obj;
			JSONArray key = (JSONArray) jobj.get("samples");
			Iterator trials = key.iterator();
			while (trials.hasNext()){
				JSONArray w = (JSONArray) trials.next();
				Iterator word = w.iterator();
				j=0;
				while (word.hasNext()){
					JSONArray d = (JSONArray) word.next();
					Iterator details = d.iterator();
					String l = (String) details.next();
					Long pr = (Long) details.next();
					Long re = (Long) details.next();
					p.trials[i].words[j].letter = l;
					p.trials[i].words[j].pressed = pr;
					p.trials[i].words[j].released = re;
					j++;
				}
				i++;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
