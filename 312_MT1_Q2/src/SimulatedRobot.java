import java.io.IOException;


public class SimulatedRobot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SimulatedRobot r1 = new SimulatedRobot(System.in,System.out);
		PacketStream ps = new PacketStream(System.in, System.out);
		Packets p = new Packets(0,0,"");
		while (true){
			p.ramdomPacket();
			try {
				ps.sendPacket(p);
				System.out.println("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				
				Thread.currentThread().sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
