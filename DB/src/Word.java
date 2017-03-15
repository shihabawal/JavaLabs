public class Word {
	public Long pressed, released;
	public String letter;
	public Word(){
		pressed = new Long(0);
		released = new Long(0);
		letter = "\0";
	}
}
