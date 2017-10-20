package example;

import example.clock.Clock;
import example.clock.EnglishClock;
import example.clock.ISOClock;
import example.month.Month;
import example.parser.Parser;
import example.parser.ParserException;

public class Main {
	private static void clock() {
		Clock cl1 = new EnglishClock();
		Clock cl2 = new ISOClock();
		System.out.println(cl1.getTime());
		System.out.println(cl2.getTime());
	}
	private static void month() {
		for(Month month: Month.values()) {
			System.out.println("Month " + month + " has " + month.days + " days.");
		}
	}
	private static void parser() {
		System.out.print("1234.50 = ");
		try {
			System.out.println(Parser.parse("1234.50"));
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
			System.out.println("Message: " + e.getMessage());
		} catch (ParserException e) {
			System.out.println("ParserException");
			System.out.println("Message: " + e.getMessage());
		}
		System.out.print("\"\" = ");
		try {
			System.out.println(Parser.parse(""));
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
			System.out.println("Message: " + e.getMessage());
		} catch (ParserException e) {
			System.out.println("ParserException");
			System.out.println("Message: " + e.getMessage());
		}
		System.out.print("12a = ");
		try {
			System.out.println(Parser.parse("12a"));
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
			System.out.println("Message: " + e.getMessage());
		} catch (ParserException e) {
			System.out.println("ParserException");
			System.out.println("Message: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println("Clock Example:");
		clock();
		System.out.println("\n\nMonth Example:");
		month();
		System.out.println("\n\nParser Example:");
		parser();
		
	}

}
