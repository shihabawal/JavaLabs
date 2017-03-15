import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class PacketStream {

	DataInputStream is;
	DataOutputStream os;
	
	public PacketStream(InputStream is, OutputStream os){
		this.is = new DataInputStream(is);
		this.os = new DataOutputStream(os);
	}
	
	public void sendPacket(Packets p) throws IOException{
		os.writeDouble(p.getNum1());
		os.writeDouble(p.getNum2());
		os.writeBytes(p.getS());
	}
	
	public Packets recvPacket() throws IOException{
		double n1 = is.readDouble();
		double n2 = is.readDouble();
		String s = is.readUTF();
		Packets p = new Packets(n1, n2, s);
		return p;
	}
}
