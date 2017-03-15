import java.io.*;

public class FrenchDataOutputStream extends DataOutputStream implements
		FrenchWrite {

	public FrenchDataOutputStream(OutputStream out) {
		super(out);
	}

	@Override
	public void ecrire(int b) throws IOException {
		super.write(b);
	}

	@Override
	public void rougir() throws IOException {
		super.flush();
	}

	@Override
	public void fin() throws IOException {
		super.close();
	}

}
