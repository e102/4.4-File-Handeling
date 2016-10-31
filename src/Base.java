import java.io.BufferedReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/* takes input and passes it to function (DONE)
 * function splits input, comma is delimiter ()
 * function counts lines and adds to count
 * 
 */

public class Base {
	public static void main(String[] args) {
		int count = 0;
		String in;
		
		System.out.println("This program counts the number of lines in the files you specify.");
		System.out.println("Please type your files, seperated by commas, and press enter.");
		Scanner s = new Scanner(System.in);
		in = s.nextLine();
		
		String[] userInput = splitInput(in);
		
		for (String path : userInput) {
			try {
				System.out.println("Path = " + path);
				count += countLines(in);
			} catch (FileNotFoundException e) {
				System.out.println("file " + path + " not found. Moving on to next file");
			}
		}
		
		System.out.println("Total lines in all files = " + count);
	}
	
	public static int countLines(String s) throws FileNotFoundException{
		BufferedReader bReader = new BufferedReader(new FileReader(s));
		
		int count = 0;
		try {
			while(bReader.readLine() != null){
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static String[] splitInput(String s){
		String[] a = s.split(",");
		return a;
	}

}
