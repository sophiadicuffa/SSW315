import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


public class DirectoryUtil {

	private static final DecimalFormat df = new DecimalFormat("0.00");

	private static void getFileReport(String folderName) throws FileNotFoundException {
		PrintWriter output = new PrintWriter("EC.log");
		File file1 = new File(folderName);
		String contents[] = file1.list();
		String main = file1.getName();
		output.print(getNumberOfFiles(file1) + "    " + getRightSize((file1)) + "   " + main + "\n");
		for(int i=0; i< contents.length -1; i++) {
			File subFolder = new File(folderName + "\\" + contents[i]);
			output.print(getNumberOfFiles(subFolder) + "    " + getRightSize((subFolder)) + "   " + main + "/" + contents[i]+ "\n");
			if(getFolderCount(subFolder) > 0) {
				File[] subCon = subFolder.listFiles(File::isDirectory);
				for (int j = 0; j < subCon.length - 1; j ++) {
					File subFolder2 = subCon[j];
					output.print(getNumberOfFiles(subFolder2) + "    " + getRightSize((subFolder2)) + "   "+ main + "/" + contents[i] + "/" + subFolder2.getName()+ "\n");
				}
			}
		}
		output.close();
	}

	private static double getFolderSize(File folder) {

		long length = 0;
		File[] files = folder.listFiles();

		int count = files.length;
		for (int i = 0; i < count; i++) {
			if (files[i].isFile()) {
				length += files[i].length();
			}
			else {
				length += getFolderSize(files[i]); // GETS SIZE IN BYTES
			}
		}
		return length;
	}


	public static long getNumberOfFiles(File file) {
		long numberOfFiles = 0; // Store the total size of all files
		// System.out.println(file);
		if (file.isDirectory()) {
			File[] files = file.listFiles(); // All files and subdirectories
			for (int i = 0; i < files.length; i++) {
				numberOfFiles += getNumberOfFiles(files[i]); // Recursive call
			}
		}
		else { // Base case
			numberOfFiles++;
		}

		return numberOfFiles;
	}

	private static int getFolderCount(File folder) {
		int numberOfSubfolders = 0;
		File listDir[] = folder.listFiles();
		for (int i = 0; i < listDir.length; i++) {
			if (listDir[i].isDirectory()) {
				numberOfSubfolders++;
			}
		}
		return numberOfSubfolders;
	}

	private static String getRightSize(File folder) {
		double size = getFolderSize(folder);

		String[] units = new String[] {"B","KB","MB","GB","TB"};
		int ind = (int)(Math.log10(size)/3);
		double val =  1 << (ind *10);

		return df.format(size / val) + " " + units[ind];
	}

	public static void main(String[] args) throws IOException	{
		String file1 = "C:\\Users\\sophi\\OneDrive\\Desktop\\EC"; //file link here
		getFileReport(file1);

//		    try {
//		      PrintWriter output = new PrintWriter("output.txt");
//
//		      output.print(data);
//		      output.close();
//		    }
//		    catch(Exception e) {
//		      e.getStackTrace();
//		    }

	}
}
