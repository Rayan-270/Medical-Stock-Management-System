package programming;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Medicine2021 {
	private LastMedicinesUpdate array;
	private ArrayList<String> medicines;
	private ArrayList <String> medicinesInPharmacy;
	
	public Medicine2021() {
		medicines = new ArrayList<>();
		array = new LastMedicinesUpdate();
		medicinesInPharmacy = array.getMedicineArray();
	}
	public void printMedicine2021() {
		
		for(String name : medicinesInPharmacy) {
			StringTokenizer medicineInfo = new StringTokenizer(name , "|");
			medicineInfo.nextToken();
			medicineInfo.nextToken();
			medicineInfo.nextToken();
			StringTokenizer year = new StringTokenizer(medicineInfo.nextToken() , ":");
			year.nextToken();
			if(Double.parseDouble(year.nextToken()) <= 2021) {
				medicines.add(name);
			}
		}
		for(String m : medicines) {
			System.out.println(m);
		}
	}

}
