package programming;

public class Carbage {
	private SearchForMedicineInFile search;
	private PharmacyDatabase pharmacy;
	
	public Carbage() {
			search = new SearchForMedicineInFile();
			pharmacy = new PharmacyDatabase();
	}
	public void deletIt(String medicineName){
		if(!search.isDeletedMedicine(medicineName)){
		 	 if (!search.searchInMedicinesFile(medicineName).equals("")){
		  		pharmacy.savedeletedMedicineName(medicineName);
		  		System.out.println("Medicine Deleted Successful");
		 	 }
		 	else 
		 		System.out.println("Unavailable Medicine in pharmacy's database");
		  }
		  else
		  	System.out.println("This medicine was deleted before !");
		 
		}
		
	}
