package programming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MedicinesReports {
	private ArrayList<String> allMedicines;
	private ArrayList<String> medicinesArray;
	private ArrayList<String> deletedMedicinesArray;
	private ArrayList<String> medicinesNamesArray;
	private ArrayList<String> specifiedMedicines;
	private PharmacyDatabase pharmacy;
	
	public MedicinesReports() {
			pharmacy = new PharmacyDatabase();
			allMedicines = new ArrayList<>();
			medicinesArray = pharmacy.getMedicines();
			deletedMedicinesArray = pharmacy.getDeletedMedicines();
			medicinesNamesArray = pharmacy.getAllMedicineNames();
			specifiedMedicines = getMedicineArray();
	}
	public ArrayList<String> deletedMedicines(ArrayList<String> medicinesArray){
		for(String deletedM : deletedMedicinesArray) {
			for(int index = medicinesArray.size() - 1 ; index >= 0 ; index--) {
				StringTokenizer medicine = new StringTokenizer(medicinesArray.get(index) , "|");
				medicine.nextToken();
				StringTokenizer medicineName  = new StringTokenizer(medicine.nextToken() , ": ");
				medicineName.nextToken();
				String name =  medicineName.nextToken();
				if (name.equalsIgnoreCase(deletedM)) {
					medicinesArray.remove(index);
				}
			}

		}
		return medicinesArray;
	}
	public ArrayList<String> getMedicineArray(){
			//clear array to reset new medicine information
			if(allMedicines.size() != 0) {
				allMedicines.clear();
			}
			ArrayList <String> medicines = deletedMedicines(medicinesArray); 
			//reverse array to get last medicine's updates
			Collections.reverse(medicines);
			for(String name : medicinesNamesArray) {
				for(String medicine : medicines) {
					StringTokenizer medicineReport = new StringTokenizer(medicine , "|");
					medicineReport.nextToken();
					StringTokenizer medicineUniver = new StringTokenizer(medicineReport.nextToken() , ": ");
					medicineUniver.nextToken();
					String universalName = medicineUniver.nextToken();
					if (universalName.trim().equalsIgnoreCase(name.trim())) {
						allMedicines.add(medicine);
						break;
					}
				}
			}
		return allMedicines;
	}
	public ArrayList<String> getSpecificMedicines(double userPrice){
		if(specifiedMedicines.size() > 0) {
			specifiedMedicines.clear();
		}
		for(int medicineIndex = specifiedMedicines.size() - 1 ; medicineIndex >= 0 ; medicineIndex --) {
			StringTokenizer name = new StringTokenizer(specifiedMedicines.get(medicineIndex) , "|");
			for(int index = 1 ; index <= 5 ; index ++) {
				name.nextToken();
			}
			StringTokenizer price = new StringTokenizer(name.nextToken() , ": ");
			price.nextToken();
			if (Double.parseDouble(price.nextToken()) > userPrice) {
				specifiedMedicines.remove(medicineIndex);
			}
		}
	
		return specifiedMedicines;
	}
	public ArrayList<String> getMedicine2021(){
		return deletedMedicines(pharmacy.getMedicines2021());
		
	}
}