package programming;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SellMedicine {
	private FileWriter WriteMedicinefile ;
	private PrintWriter writeMedicine;
	private RandomAccessFile readDeletedMedicines;
	private ArrayList<String> deleted;
	private ReverseFile reverseFile;
	
	public SellMedicine () {
		try { 
			WriteMedicinefile = new FileWriter ("MedicinesFile#.txt" , true);
			writeMedicine = new PrintWriter (WriteMedicinefile);
			reverseFile = new ReverseFile();
			deleted = new ArrayList<>(); 
			readDeletedMedicines = new RandomAccessFile("Bin#.txt" , "r");
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
	}
public void sellMedicine (String medicineName , int medicineQuantity) {
	try { 
		boolean deletedmedicine = false;
		String deletedMedicine;
		while((deletedMedicine = readDeletedMedicines.readLine()) != null) {
			deleted.add(deletedMedicine);
		}
		readDeletedMedicines.seek(0);
		for(String medicine : deleted) {
			if(medicineName.toLowerCase().contains(medicine.toLowerCase())) {
				deletedmedicine = true;
			}
		}
		if(deletedmedicine == false) {
			String line2;
			String numberAsString = "";
			String newQuantityAsString = "";
			boolean found = false;
				if (!reverseFile.returnIntendedLine(medicineName).equals("")){
					found = true;
					String requiaredLine = reverseFile.returnIntendedLine(medicineName);
					StringTokenizer string = new StringTokenizer(requiaredLine , "|");
					for(int i = 0 ; i < 4 ; i ++) {
						string.nextToken();
					}
					StringTokenizer medicineOldQuantity = new StringTokenizer(string.nextToken(), " ");
					medicineOldQuantity.nextToken();
					double quantityInPharmacy = Double.parseDouble(medicineOldQuantity.nextToken()); 
					if (quantityInPharmacy >= medicineQuantity) {
						numberAsString += quantityInPharmacy;
						newQuantityAsString += (quantityInPharmacy - medicineQuantity);
						String modifiedLine = requiaredLine.replace(numberAsString , newQuantityAsString);
						writeMedicine.println(modifiedLine);
						writeMedicine.flush();
						System.out.println("A New Medicine Added to Your Cart Sucsessfuly ");
						
					}
					else
					System.out.println("This Quantity is more than what is available in the Pharamcy");
		}
				if (found == false)
				System.out.println("Medicine Not Found !");
		}
		else
			System.out.println("This Medicine Was Deleted !");
	}catch(Exception exception) {
		System.out.println(exception);
	}
  }
}
