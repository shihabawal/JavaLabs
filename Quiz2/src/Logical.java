import java.io.*;

public class Logical{
	public boolean read (DataInputStream in) throws IOException{
		return in.readBoolean();
	}
	public void write (DataOutputStream out, boolean val) throws IOException{
		out.writeBoolean(val);
	}
}
