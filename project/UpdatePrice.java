package programming;
import java.util.StringTokenizer;


public class UpdatePrice implements UpdateElement { 
	private SearchForMedicineInFile search;
	private PharmacyDatabase pharmacy;
	
	public UpdatePrice() {
			search = new SearchForMedicineInFile();
			pharmacy = new PharmacyDatabase();
		}
	public void Update(String name, double number) {
			StringTokenizer modifiedLines;
			String medicineName ;
			String newLine;
			String oldPrice;
			String newPrice = "" ;
			String numberAsString = "";
			String newNumberAsString = "";
			String nameAndPrice;
			//register changes in medicine's price file
			for(int index = 0 ; index < pharmacy.getMedicinePrice().size(); index++) {
				if(pharmacy.getMedicinePrice().get(index).toLowerCase().contains(name.toLowerCase()) ) {
					modifiedLines = new StringTokenizer(pharmacy.getMedicinePrice().get(index) , " ");
					medicineName = modifiedLines.nextToken();
					oldPrice = modifiedLines.nextToken();
					pharmacy.saveNameAndPrice(medicineName , number);
					break;
				}
			}
			//register changes in medicine's file
					String requiaredLine = search.searchInMedicinesFile(name); 
					StringTokenizer string = new StringTokenizer(requiaredLine , "|");
					for ( int i = 0 ; i < 5 ; i ++) {
						string.nextToken();
					}
					StringTokenizer medicineOldPrice = new StringTokenizer(string.nextToken(), ": ");
					medicineOldPrice.nextToken();
					numberAsString += medicineOldPrice.nextToken();
					String modifiedLine = requiaredLine.replace(numberAsString ,newNumberAsString += number);	
					pharmacy.saveMedicine(modifiedLine); 
	}

}

