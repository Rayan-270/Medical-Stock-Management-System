package programming;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SpecifiedMedicinePrice {
	private LastMedicinesUpdate array;
	private ArrayList<String> medicinesReports;
	private ArrayList <String> medicinesInPharmacy;
	
	public SpecifiedMedicinePrice() {
		array = new LastMedicinesUpdate();
		medicinesReports = new ArrayList<>();
		medicinesInPharmacy = array.gitMedicineArray();
	}
	public void printMedicinesWithSpecificPrice(double userprice) {
		for(String medicine : medicinesInPharmacy) {
			StringTokenizer name = new StringTokenizer(medicine , "|");
			for(int index = 1 ; index <= 5 ; index ++) {
				name.nextToken();
			}
			StringTokenizer price1 = new StringTokenizer(name.nextToken() , ":");
			price1.nextToken();
			if (Double.parseDouble(price1.nextToken()) <= userprice) {
				medicinesReports.add(medicine);
			}
		}
		for(String s : medicinesReports) {
			System.out.println(s);
		}
	}
}
