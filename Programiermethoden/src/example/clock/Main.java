package example.clock;

public class Main {

	public static void main(String[] args) {
		Clock cl1 = new EnglishClock();
		Clock cl2 = new ISOClock();
		System.out.println(cl1.getTime());
		System.out.println(cl2.getTime());
	}

}
