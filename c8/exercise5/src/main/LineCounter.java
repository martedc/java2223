package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**<p>Designed for use in cmd prompt.</p>
 * <p>Navigate to: cd C:\Workspaces\java2223\c8\exercise5\src\main</p> 
 * <p>Select the java JDK: set path=%path%;C:\Program Files\Javajdk</p>
 * <p>Compile with: javac LineCounter.java</p>
 * <p>Run using: java LineCounter file1.txt file2.txt file3.txt</p>
 * 
 * @author Marten
 *
 */
public class LineCounter {

	public static void main(String[] args) {
		
		for (String s : args) {
			File myFile = new File("C:\\Workspaces\\java2223\\c8\\exercise5\\src\\main\\" + s);
			int lineCount = 0;
			
			try {
				Scanner scan = new Scanner(myFile);
				String scanLine = scan.nextLine();
				
				while (scanLine != null) {
						lineCount += 1;
						if (scan.hasNextLine()) {
							scanLine = scan.nextLine();
						} else {
							break;
						}
				}
				scan.close();
				System.out.println(s + " " + lineCount);
				
			} catch (FileNotFoundException e) {
				System.out.println("Error - Specified file not found");
				e.printStackTrace();
				continue;
			}
		}

	}

}
