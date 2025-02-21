package programming;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class UpdateQuatity implements UpdateElement {
	private FileWriter WriteMedicinefile ;
	private PrintWriter writeMedicine;
	private ReverseFile reversFile ;
	
	public UpdateQuatity() {
		try { 
			WriteMedicinefile = new FileWriter ("MedicinesFile#.txt" , true);
			writeMedicine = new PrintWriter (WriteMedicinefile);
			reversFile = new ReverseFile();
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		}
	public void Update(String name, double number) {
			try { 
				String numberAsString = "";
				String newNumberAsString = "";
						String requiaredLine = reversFile.returnIntendedLine(name); 
						StringTokenizer string = new StringTokenizer(requiaredLine , "|");
						for( int i = 0 ; i < 4 ; i++) {
							string.nextToken();
						}
						StringTokenizer medicineOldPrice = new StringTokenizer(string.nextToken(), " ");
						medicineOldPrice.nextToken();
						numberAsString += medicineOldPrice.nextToken();
						String modifiedLine = requiaredLine.replace(numberAsString , newNumberAsString += number);
						writeMedicine.println(modifiedLine);
						writeMedicine.flush();
				
			}catch(Exception exception) {
				System.out.println(exception);
			}
		
		}

}
