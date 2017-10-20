package example.parser;

public class Parser {
	
	public static Double parse(String binarystring) throws ParserException, IllegalArgumentException {
		if (binarystring == null || binarystring.equals("")) {
			throw new IllegalArgumentException();
		}
		Double number;
		try {
			number = Double.parseDouble(binarystring);
		} catch (NumberFormatException e) {
			throw new ParserException("");
		}
		return number;
	}

}
