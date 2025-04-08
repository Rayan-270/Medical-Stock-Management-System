package programming;
import java.util.StringTokenizer;


public class UpdateQuatity implements UpdateElement {
	private SearchForMedicineInFile search ;
	private PharmacyDatabase pharmacy;
	
	public UpdateQuatity() {
		try { 
			search = new SearchForMedicineInFile();
			pharmacy = new PharmacyDatabase();
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		}
	public void Update(String name, double number) {
			try { 
				String quantityAsString = "";
				String newQuantityAsString = "";
						String requiaredLine = search.searchInMedicinesFile(name);  
						StringTokenizer string = new StringTokenizer(requiaredLine , "|");
						for( int i = 0 ; i < 4 ; i++) {
							string.nextToken();
						}
						StringTokenizer medicineOldQuantity = new StringTokenizer(string.nextToken(), ": ");
						medicineOldQuantity.nextToken();
						quantityAsString += medicineOldQuantity.nextToken();
						String modifiedLine = requiaredLine.replace(quantityAsString , newQuantityAsString += number);
						pharmacy.saveMedicine(modifiedLine); 
				
			}catch(Exception exception) {
				System.out.println(exception);
			}
		
		}

}
