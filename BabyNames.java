import java.io.*;
import java.util.*;

public class BabyNames {
	public static void printCSV(Map<String, List<String>> data, String input, String gender) {
		String eol = System.getProperty("line.separator");
		String printgender = "";
		if(gender.equals("M")) {
			printgender = "Boy";
		} else if (gender.equals("F")) {
			printgender = "Girl";
		}
		try (Writer writer = new FileWriter(input + "_RankedBaby" + printgender + "Names.csv")) {
			int linecount = 0;
			for (Map.Entry<String, List<String>> entry : data.entrySet()) {
				if(linecount > 100) {
					break;
				}
				writer.append(entry.getKey()).append(',');
				for (String count : entry.getValue()) {
					writer.append(count).append(',');
				}
				writer.append(eol);
				linecount ++;
					
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
	public static void sortYear(Map<String, List<String>> data, String input, String gender) {
		int inputIndex = Integer.parseInt(input) - 1910;
		Map<String, List<String>> output = new LinkedHashMap<String, List<String>>();
		Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, List<String>> entry : data.entrySet()) {		
			int index = 0;
			int value = 0;
			for (String count : entry.getValue()) {						
				if(index == inputIndex) {
					value = Integer.parseInt(count);
					break;
				}
				index++;
			}
			temp.put(entry.getKey(), value);							
		}
		Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
		temp.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		  .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
		List<String> titleRow = new LinkedList<String>();
		for (int i = 0; i < 112; i++) {
			int year = 1910 + i;
			titleRow.add(String.valueOf(year));
		}
		output.put("name", titleRow);
        for(String key : sorted.keySet()) {
        	output.put(key, data.get(key));
        }
		printCSV(output, input, gender);
	}
	
	public static void sortDecade(Map<String, List<String>> data, String input, String gender) {
		String trimmed = input.substring(0, input.length() - 1);
		int startIndex = Integer.parseInt(trimmed) - 1910;
		Map<String, List<String>> output = new LinkedHashMap<String, List<String>>();
		Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, List<String>> entry : data.entrySet()) {		
			int index = 0;
			int totalcount = 0;
			for (String count : entry.getValue()) {						
				if(index == startIndex || index == startIndex + 1 || index == startIndex + 2 || index == startIndex + 3 || index == startIndex + 4 || index == startIndex + 5 || index == startIndex + 6 
						|| index == startIndex + 7 || index == startIndex + 8 || index == startIndex + 9) {
					totalcount += Integer.parseInt(count);
				}
				index++;
			}
			temp.put(entry.getKey(), totalcount);							
		}
		Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
		temp.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		  .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
		List<String> titleRow = new LinkedList<String>();
		for (int i = 0; i < 112; i++) {
			int year = 1910 + i;
			titleRow.add(String.valueOf(year));
		}
		output.put("name", titleRow);
        for(String key : sorted.keySet()) {
        	output.put(key, data.get(key));
        }
		printCSV(output, input, gender);
	}
	
	public static void sortAll(Map<String, List<String>> data, String gender) {
		Map<String, Integer> temp = new LinkedHashMap<String, Integer>();	
		for(Map.Entry<String, List<String>> entry : data.entrySet()) {		
			int totalcount = 0;
			for (String count : entry.getValue()) {							
				totalcount += Integer.parseInt(count);						
			}
			temp.put(entry.getKey(), totalcount);							
		}
		Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
		temp.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		  .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
        Map<String, List<String>> output = new LinkedHashMap<String, List<String>>();
        List<String> titleRow = new LinkedList<String>();
		for (int i = 0; i < 112; i++) {
			int year = 1910 + i;
			titleRow.add(String.valueOf(year));
		}
		output.put("name", titleRow);
        for(String key : sorted.keySet()) {
        	output.put(key, data.get(key));
        }
        printCSV(output, "all", gender);
	}
	
	public static void newName(Map<String, List<String>> data, String[] contents, List<String> list) {
		list = new LinkedList<String>();											 
		data.put(contents[3], list);												
		for (int i = 0; i < 112; i++) {												
			list.add("0");
		}
		int index = Integer.parseInt(contents[2]) - 1910;							
		list.set(index, contents[4]);												
	}
	
	public static void repeatName(Map<String, List<String>> data, String[] contents, List<String> list) {
		int index = Integer.parseInt(contents[2]) - 1910;							
		int current = Integer.parseInt(list.get(index));							
		int updated = Integer.parseInt(contents[4]) + current;						
		list.set(index, String.valueOf(updated));									
	}
	
	public static void process(Map<String, List<String>> data, File file, String gender) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));  
		String[] contents = new String[4];
		for(String line = br.readLine(); line != null; line = br.readLine()) {		
			contents = line.split(",");												
			if(contents.length == 5 && contents[1].equals(gender)) {				
				List<String> list = data.get(contents[3]);							
	            if (list == null) {									
	            	newName(data, contents, list);									
	            } else { 
	            	repeatName(data, contents, list);								
	            }
			}
		}
		br.close();
	}
	
	public static void main(String[] args) throws Exception {
		File directory = new File("C:\\Users\\sophi\\eclipse-workspace\\BabyNames\\namesbystate");	
		Map<String, List<String>> dataM = new LinkedHashMap<>();
		Map<String, List<String>> dataF = new LinkedHashMap<>();
		for(File file : directory.listFiles()) {	
			try {	
				process(dataM, file, "M");
			} catch (Exception e) {
	            e.printStackTrace();
			}
			try {
				process(dataF, file, "F");
	        } catch (Exception e) {
	           e.printStackTrace();
	        }	
		}
		String input = "all";
		if(input.equals("all")) {
			sortAll(dataM, "M");
			sortAll(dataF, "F");
		} else if (input.endsWith("s")) {
			sortDecade(dataM, input, "M");
			sortDecade(dataF, input, "F");
		} else {
			sortYear(dataM, input, "M");
			sortYear(dataF, input, "F");
		}
	}
}