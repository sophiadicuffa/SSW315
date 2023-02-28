import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;

public class DuplicateFileFinder {
	private static final DecimalFormat two = new DecimalFormat("0.00");
	private static MessageDigest messageDigest;

	static {
		try {
			messageDigest = MessageDigest.getInstance("SHA-1");
		} catch(NoSuchAlgorithmException e) {
			throw new RuntimeException("cannot initialize SHA-1 hash function", e);
		}
	}

	public static String getHash(File file) throws Exception { // get hash for file
		FileInputStream fileStream = new FileInputStream(file);
		byte data[] = new byte[(int)file.length()];
		fileStream.read(data);
		fileStream.close();
		String hash = new BigInteger(1, messageDigest.digest(data)).toString(16);
		return hash;
	}

	public static void find(Map<String, List<String>> lists, File directory) throws Exception  { //find duplicates
		String hash;
		for (File file : directory.listFiles()) {
			if (file.isDirectory()) {
				find(lists, file);
			} else {
				try {
					hash = getHash(file);
					List<String> list = lists.get(hash);
					if (list == null) {
						list = new LinkedList<String>();
						lists.put(hash, list);
					}
					list.add(file.getAbsolutePath());
				} catch (IOException e) {
					throw new RuntimeException("cannot read file " + file.getAbsolutePath(), e);
				}
			}
		}
	}

	public static String getSize(File file) { // get correct units of file size
		String[] byteArray = new String[] {"B","KB","MB","GB","TB"};
		int index = (int)(Math.log10(file.length()) / 3);
		return two.format(file.length() / (1 << (index *10))) + " " + byteArray[index];
	}

	public static void main(String[] args) throws Exception { //The program should compare the contents of all files in the directory given as an argument and produce a "duplicates.log" file that lists a group of files that have the same content.
		PrintWriter fileOut = new PrintWriter("duplicates.log");
		File dir = new File(args[0]);
		Map<String, List<String>> lists = new HashMap<String, List<String>>();
		try {
			find(lists, dir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (List<String> list : lists.values()) {
			if (list.size() > 1) {
				File duplicate = new File(list.get(0));
				fileOut.println("# " + list.size() + "   " + getSize(duplicate) + " " + getHash(duplicate));
				for (String file : list) {
					fileOut.println(file);
				}
				fileOut.print("\n");
			}
		}
		fileOut.close();
	}
}