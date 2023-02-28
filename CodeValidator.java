import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class CodeValidator {

	public static ArrayList<String> readInFile(String fileName) throws IOException {

		FileInputStream file = new FileInputStream(fileName);
		Scanner in = new Scanner(file);
		ArrayList<String> lines = new ArrayList<String>();
		String line;
		while(in.hasNextLine()) {
			line = in.nextLine();
			if (!line.contains("//"))
				lines.add(line);
			
		}
		file.close();
		in.close();
		return lines;
	}

	public static boolean containsMismatchedBrackets(List<String> lines) {

		Stack<String> s = new Stack<String>();
		String character;
		for (String line : lines) {
			for (int i = 0; i < line.length(); i++) {
				character = String.valueOf(line.charAt(i));
				if (character.equals("{") || character.equals("(") || character.equals("[") || character.equals("'") || character.equals("\"")) {
					s.push(character);
				}

				if (s.isEmpty() && (character.equals("}") || character.equals(")") || character.equals("]"))){
					System.out.printf("Error. Stack empty, no opening bracket to match closing %s.\n", character);
					System.out.printf("On line %s. \n", lines.indexOf(line));
					return true;
				}

				if (character.equals("]")) {
					String c = s.pop();
					if (!c.equals("[")) {
						System.out.printf("Error. Closing ] encountered. Does not match %s popped off the stack.\n", c);
						System.out.printf("On line %s. \n", lines.indexOf(line));
						return true;
					}
				}
				if (character.equals("}")) {
					String c = s.pop();
					if (!c.equals("{")) {
						System.out.printf("Error. Closing } encountered. Does not match %s popped off the stack.\n", c);
						System.out.printf("On line %s. \n", lines.indexOf(line));
						return true;
					}
				}

				if (character.equals(")")) {
					String c = s.pop();
					if (!c.equals("(")) {
						System.out.printf("Error. Closing ) encountered. Does not match %s popped off the stack.\n", c);
						System.out.printf("On line %s. \n", lines.indexOf(line));
						return true;
					}
				}

				if (character.equals("'")) {
					String c = s.pop();
					if (!c.equals("'")) {
						System.out.printf("Error. No closing ' encountered.\n", c);
						System.out.printf("On line %s. \n", lines.indexOf(line));
						return true;
					}
				}
				
				if (character.equals("\"")) {
					String c = s.pop();
					if (!c.equals("\"")) {
						System.out.printf("Error. No closing \" encountered.\n", c);
						System.out.printf("On line %s. \n", lines.indexOf(line));
						return true;
					}
				}
			}
		}

		if (!s.isEmpty()) {
			System.out.printf("Error. One or more opening brackets never closed.\n", s.peek());
			return true;
		}
		else {
			System.out.println("All brackets are balanced.");
			return false;
		}
	}

	public static boolean runCheck(String fileName) throws IOException {

		ArrayList<String> lines = readInFile(fileName);

		boolean mismatched = containsMismatchedBrackets(lines);
		if(mismatched) {
			System.out.printf("%s contains mismatched brackets.\n", fileName);
		}
		return mismatched;	
	}

	public static void main(String[] args) throws IOException {

		String fileName = args[0]; //"C:\Users\sophi\eclipse-workspace\CodeValidator\Resources\HelloWorld.java"
		runCheck(fileName);
	}
}

