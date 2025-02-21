package programming;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class UpdatePrice implements UpdateElement { 
	private FileWriter WriteMedicinefile ;
	private PrintWriter writeMedicine;
	private ReverseFile reverseFile;
	private RandomAccessFile readNamesAndPrice;
	private FileWriter file;
	private PrintWriter writeNewPrice;
	private ArrayList<String> namesAndPriceArrayList;
	
	public UpdatePrice() {
		try { 
			WriteMedicinefile = new FileWriter ("MedicinesFile#.txt" , true);
			writeMedicine = new PrintWriter (WriteMedicinefile);
			reverseFile = new ReverseFile();
			readNamesAndPrice = new RandomAccessFile("MedicinesAndPrice#.txt" , "r");
			namesAndPriceArrayList = new ArrayList<>();
			file = new FileWriter("MedicineAndPrice#.txt" , true);
			writeNewPrice = new PrintWriter(file);
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		}
	public void Update(String name, double number) {
		try { 
			StringTokenizer modifiedLines;
			String newLine;
			String oldPrice;
			String newPrice = "" ;
			String numberAsString = "";
			String newNumberAsString = "";
			String nameAndPrice;
			while((nameAndPrice = readNamesAndPrice.readLine()) != null) {
				namesAndPriceArrayList.add(nameAndPrice);
			}
			readNamesAndPrice.seek(0);
			//تعيير قيمه الدواء في ملف namesandaparice 
			for(int index = 0 ; index < namesAndPriceArrayList.size(); index++) {
				if(namesAndPriceArrayList.get(index).toLowerCase().contains(name.toLowerCase()) ) {
					modifiedLines = new StringTokenizer(namesAndPriceArrayList.get(index) , " ");
					modifiedLines.nextToken();
					oldPrice = modifiedLines.nextToken();
					newLine = namesAndPriceArrayList.get(index).replace(oldPrice, newPrice += number);
					writeNewPrice.println(newLine);
					writeNewPrice.flush();
					break;
				}
			}
			// تغيير قيمه الدواء في ملف FileMedicine
					String requiaredLine = reverseFile.returnIntendedLine(name); 
					StringTokenizer string = new StringTokenizer(requiaredLine , "|");
					for ( int i = 0 ; i < 5 ; i ++) {
						string.nextToken();
					}
					StringTokenizer medicineOldPrice = new StringTokenizer(string.nextToken(), " ");
					medicineOldPrice.nextToken();
					numberAsString += medicineOldPrice.nextToken();
					String modifiedLine = requiaredLine.replace(numberAsString ,newNumberAsString += number);
					writeMedicine.println(modifiedLine);					
					writeMedicine.flush();
			
		}catch(Exception exception) {
			System.out.println(exception);
		}
	}

}

