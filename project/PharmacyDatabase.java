/*Database tracking addition and deletion
 * */

package programming;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PharmacyDatabase {
	private FileWriter medicines2021File;
	private FileWriter allMedicineNamesFile;
	private FileWriter deletedMedicinesFile;
	private FileWriter medicinesFile;
	private FileWriter medicinesPriceFile;
	private PrintWriter medicines2021Write;
	private PrintWriter allMedicineNamesWrite;
	private PrintWriter deletedMedicinesWrite;
	private PrintWriter medicinesWrite;
	private PrintWriter medicinesPrice;
	private RandomAccessFile medicines2021Read;
	private RandomAccessFile allMedicineNamesRead;
	private RandomAccessFile deletedMedicinesRead;
	private RandomAccessFile meicinesRead;
	private RandomAccessFile medicinesPriceRead;
	private ArrayList<String> medicines2021Array;
	private ArrayList<String> allMedicineNamesArray;
	private ArrayList<String> deletedMedicinesArray;
	private ArrayList<String> medicinesArray;
	private ArrayList<String> medicinesPriceArray;
	private static int medicineNumber = 0;
	
	public PharmacyDatabase() {
		try {
			medicines2021File = new FileWriter("medicines2021.txt" , true);
			allMedicineNamesFile = new FileWriter ("Names#.txt" , true);
			deletedMedicinesFile  = new FileWriter("Bin#.txt" , true);
			medicinesFile = new FileWriter ("MedicinesFile.txt" , true);
			medicinesPriceFile = new FileWriter("MedAndPRI.txt" , true);
			medicines2021Write = new PrintWriter(medicines2021File);
			allMedicineNamesWrite = new PrintWriter(allMedicineNamesFile);
			deletedMedicinesWrite = new PrintWriter(deletedMedicinesFile);
			medicinesWrite = new PrintWriter(medicinesFile);
			medicinesPrice  = new PrintWriter(medicinesPriceFile);
			medicines2021Read = new RandomAccessFile("medicines2021.txt" , "r");
			allMedicineNamesRead = new RandomAccessFile("Names#.txt" , "r");
			deletedMedicinesRead = new RandomAccessFile("Bin#.txt" , "r");
			meicinesRead = new RandomAccessFile("MedicinesFile.txt" , "r");
			medicinesPriceRead = new RandomAccessFile("MedAndPRI.txt" , "r");
			medicines2021Array = new ArrayList<>(); 
			allMedicineNamesArray = new ArrayList<>();
			deletedMedicinesArray = new ArrayList<>();
			medicinesArray = new ArrayList<>();
			medicinesPriceArray = new ArrayList<>();
		} 
		catch(Exception exception) {
			System.out.println(exception);
		}
	}
	//save medicines manufactured in 2021
	public void save2021(String medicineUniversalName ,String medicineComName ,double manufacYear ,double medicineQuantity ,double medicinePrice ,String reorderLimit) {
		medicines2021Write.println("medicineNo: " + medicineNumber++ + " |medicineUniversalName: "+ medicineUniversalName + " |medicineComName: "+ medicineComName +" |manufacYear: "+ manufacYear + " |medicineQuantity: "+ medicineQuantity + " |medicinePrice: "+ medicinePrice + " |reorderLimit: "+ reorderLimit);
		medicines2021Write.flush();
	}
	//Save all medicine names , also update names array
	public void saveName(String name) {
		allMedicineNamesWrite.println(name);
		allMedicineNamesWrite.flush();
		
	}
	//include all medicine names and prices for simple access , also update medicines price array 
	public void saveNameAndPrice(String medicineName , double medicinePrice) {
		medicinesPrice.println(medicineName + " " + medicinePrice);
		medicinesPrice.flush();
		
	}
	//include the updated info of all medicines, also update medicines's array 
	public void saveMedicine(String medicineUniversalName ,String medicineComName ,double manufacYear ,double medicineQuantity ,double medicinePrice ,String reorderLimit) {
		medicinesWrite.println("medicineNo: " + medicineNumber++ + " |medicineUniversalName: "+ medicineUniversalName + " |medicineComName: "+ medicineComName +" |manufacYear: "+ manufacYear + " |medicineQuantity: "+ medicineQuantity + " |medicinePrice: "+ medicinePrice + " |reorderLimit: "+ reorderLimit);
		medicinesWrite.flush();
		
	}
	public void saveMedicine(String medicine) {
		medicinesWrite.println(medicine);
		medicinesWrite.flush();
	}
	//include deleted medicines , also update deleted medicines's array
	public void savedeletedMedicineName(String medicineName) {
		deletedMedicinesWrite.println(medicineName);
		deletedMedicinesWrite.flush();
	}
	//return medicines manufactured in 2021 array list
	public ArrayList<String> getMedicines2021(){
		try {
			if(medicines2021Array.size() > 0 && medicines2021Read.getFilePointer() > 0) {
				medicines2021Array.clear();
				medicines2021Read.seek(0);
			}
			String line;
			while((line = medicines2021Read.readLine()) != null) {
				medicines2021Array.add(line);
			}
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		return medicines2021Array;
	}
	//return array with all medicine's names
	public ArrayList<String> getAllMedicineNames(){

		try {
			//update array 
			if(allMedicineNamesArray.size() != 0 && allMedicineNamesRead.getFilePointer() > 0) {
				allMedicineNamesArray.clear();
				allMedicineNamesRead.seek(0);
			}
			String line;
			while((line = allMedicineNamesRead.readLine()) != null) {
				allMedicineNamesArray.add(line);
			}
			
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		return allMedicineNamesArray;
	}
	//return the latest changes in the medicines file 
	public ArrayList<String> getMedicines(){

		try {
			//update array 
			if (medicinesArray.size() != 0 && meicinesRead.getFilePointer() > 0) {
				medicinesArray.clear();
				meicinesRead.seek(0);
			}
			String line;
			while((line = meicinesRead.readLine()) != null) {
				medicinesArray.add(line);
			}
			meicinesRead.seek(0);
		}
		catch(Exception exception ) {
			System.out.println(exception);
		}
		System.out.println(medicinesArray);
		return medicinesArray;
	}
	// return deleted medicine names
	public ArrayList<String> getDeletedMedicines(){
		try {
			//update array 
			if (deletedMedicinesArray.size() != 0 && deletedMedicinesRead.getFilePointer() > 0) {
				deletedMedicinesArray.clear();
				deletedMedicinesRead.seek(0);
			}
			String line;
			while((line = deletedMedicinesRead.readLine()) != null) {
				deletedMedicinesArray.add(line);
			}
			
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		return deletedMedicinesArray;
	}
	//return all medicine names and prices
	public ArrayList<String> getMedicinePrice(){
		try {
			//update array 
			if(medicinesPriceArray.size() != 0 && medicinesPriceRead.getFilePointer() > 0) {
				medicinesPriceArray.clear();
				medicinesPriceRead.seek(0);
			}
			String line;
			while((line = medicinesPriceRead.readLine()) != null) {
				medicinesPriceArray.add(line);
			}
			
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		return medicinesPriceArray;
	}

}
