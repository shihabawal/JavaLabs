import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	private Person person;

	public Reader(Person p){
		this.person = p;
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
					Double p, r;
					Object pr, re;
					JSONArray d = (JSONArray) word.next();
					Iterator details = d.iterator();
					String l = (String) details.next();
					pr = details.next ();
					re = details.next ();
					if (pr.getClass ().getName ().equals ("java.lang.Long"))
					{
						Long temp = (Long) pr;
						p = temp.doubleValue ();
					}
					else
					{
						p = (Double) pr;
					}
					if (re.getClass ().getName ().equals ("java.lang.Long"))
					{
						Long temp = (Long) re;
						r = temp.doubleValue ();
					}
					else
					{
						r = (Double) re;
					}
					person.trials[i].words[j].letter = l;
					person.trials[i].words[j].pressed = p;
					person.trials[i].words[j].released = r;
					j++;
				}
				i++;
			}
			parser.reset();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
