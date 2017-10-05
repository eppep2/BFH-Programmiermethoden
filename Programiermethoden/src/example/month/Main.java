package example.month;

public class Main {
	public static void getNumberOfDays() {
		for(Month month: Month.values()) {
			System.out.println("Month " + month + " has " + month.days + " days.");
		}
	}
	public static void main(String[] args) {
		getNumberOfDays();

	}

}
