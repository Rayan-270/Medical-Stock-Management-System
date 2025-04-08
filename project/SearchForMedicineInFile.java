package programming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class SearchForMedicineInFile {
	private PharmacyDatabase pharmacy;
	private ArrayList <String> medicineFileArray;
	private ArrayList<String> medicineNameAndPriceArray;
	private ArrayList<String> deletedMedicineArray;
	private String intendedLine;
	
	public SearchForMedicineInFile() {
		pharmacy = new PharmacyDatabase();
		
	}
	public String searchInMedicinesFile(String medicineName){
		
		medicineFileArray = new ArrayList<>() ;
		intendedLine = "";
			medicineFileArray = pharmacy.getMedicines(); 
			Collections.reverse(medicineFileArray);
			for (String index : medicineFileArray) {
				StringTokenizer line = new StringTokenizer(index , "|");
				line.nextToken();
				StringTokenizer medicineUniversalName = new StringTokenizer(line.nextToken() , ": ");
				medicineUniversalName.nextToken();
				String na = medicineUniversalName.nextToken();
				if (na.trim().equalsIgnoreCase(medicineName.trim())) {
					intendedLine += index;
					break;
				}
			}
		medicineFileArray.clear();
		return intendedLine;
	}
	public String searchForMedicineInNamesAndPriceFile(String medicineName) {
		intendedLine = "";
		medicineNameAndPriceArray = new ArrayList<>();
		medicineNameAndPriceArray = pharmacy.getMedicinePrice();
		Collections.reverse(medicineNameAndPriceArray);
		for (String index : medicineNameAndPriceArray) {
			StringTokenizer line = new StringTokenizer(index , " ");
			if (line.nextToken().equalsIgnoreCase(medicineName)) {
				intendedLine += line;
			}
		}
		return intendedLine;
	}
	public boolean isDeletedMedicine(String medicineName) {
		boolean isDeleted = false;
		deletedMedicineArray = new ArrayList<>();
		deletedMedicineArray = pharmacy.getDeletedMedicines();
		for(String medicine : deletedMedicineArray) {
			if (medicine.trim().equalsIgnoreCase(medicineName)) {
				isDeleted = true;
			}
		}
		return isDeleted;
	}
}
