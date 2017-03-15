import java.io.IOException;

public interface FrenchWrite {
	public void ecrire(int b) throws IOException;// to write

	public void rougir() throws IOException;// to flush

	public void fin() throws IOException;
}