package programming;
import java.util.StringTokenizer;

public class SellMedicine {
	private SearchForMedicineInFile search;
	private PharmacyDatabase pharmacy;
	public SellMedicine () {
		try { 
			pharmacy = new PharmacyDatabase();
			search = new SearchForMedicineInFile();
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
	}
public void sellMedicine (String medicineName , int medicineQuantity) {
	try { 
		if(!search.isDeletedMedicine(medicineName)) {
			String line2;
			String numberAsString = "";
			String newQuantityAsString = "";
			boolean found = false;
				if (!search.searchInMedicinesFile(medicineName).equals("")){
					found = true;
					String requiaredLine = search.searchInMedicinesFile(medicineName);
					StringTokenizer string = new StringTokenizer(requiaredLine , "|");
					for(int i = 0 ; i < 4 ; i ++) {
						string.nextToken();
					}
					StringTokenizer medicineOldQuantity = new StringTokenizer(string.nextToken(), ": ");
					medicineOldQuantity.nextToken();
					double quantityInPharmacy = Double.parseDouble(medicineOldQuantity.nextToken()); 
					if (quantityInPharmacy >= medicineQuantity) {
						numberAsString += quantityInPharmacy;
						newQuantityAsString += (quantityInPharmacy - medicineQuantity);
						String modifiedLine = requiaredLine.replace(numberAsString , newQuantityAsString);
						pharmacy.saveMedicine(modifiedLine);
						System.out.println("A New Medicine Added to Your Cart Sucsessfuly ");
						
					}
					else if(quantityInPharmacy < medicineQuantity && quantityInPharmacy != 0) {
					System.out.println("This Quantity is more than what is available in the Pharamcy");
					}
					else if(quantityInPharmacy == 0) {
						System.out.println("OUT OF STOCK !");
					}
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
