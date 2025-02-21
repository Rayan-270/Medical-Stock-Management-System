package programming;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class LastMedicinesUpdate {
	private RandomAccessFile medicines;
	private RandomAccessFile deletedMedicines;
	private RandomAccessFile medicinesNames;
	private ArrayList<String> lastUpdate;
	private ArrayList<String> medicinesArray;
	private ArrayList<String> deletedMedicinesArray;
	private ArrayList<String> medicinesNamesArray;
	
	public LastMedicinesUpdate() {
		try {
			medicines = new RandomAccessFile("MedicinesFile#.txt" , "r" );
			deletedMedicines = new RandomAccessFile("Bin#.txt" , "r");
			medicinesNames = new RandomAccessFile("Names#.txt" , "r");
			lastUpdate = new ArrayList<>();
			medicinesArray = new ArrayList<>();
			deletedMedicinesArray = new ArrayList<>();
			medicinesNamesArray = new ArrayList<>();
			
		}catch(Exception exception) {
			System.out.println(exception);
		}
	}
	public ArrayList<String> getMedicineArray(){

		try {
			
			if(lastUpdate.size() != 0) {
				System.out.println(lastUpdate.size());
				lastUpdate.removeIf(name -> true);
			}
			String line1;
			while((line1 = medicines.readLine()) != null) {
				medicinesArray.add(line1);
			}
			String line2;
			while((line2 = deletedMedicines.readLine()) != null) {
				deletedMedicinesArray.add(line2);
			}
			String line3;
			while((line3 = medicinesNames.readLine()) != null) {
				medicinesNamesArray.add(line3);
			}
			for(String deletedM : deletedMedicinesArray) {
				for(int index = medicinesArray.size() - 1 ; index >= 0 ; index--) {
					StringTokenizer medicine = new StringTokenizer(medicinesArray.get(index) , "|");
					medicine.nextToken();
					StringTokenizer medicineName  = new StringTokenizer(medicine.nextToken() , ":");
					medicineName.nextToken();
					String names =  medicineName.nextToken();
					//System.out.println(names);
					if (names.toLowerCase().contains(deletedM.toLowerCase())) {
						medicinesArray.remove(index);
					}
				}

			}
			Collections.reverse(medicinesArray);
			for(String name : medicinesNamesArray) {
				for(String medicine : medicinesArray) {
					StringTokenizer medicineReport = new StringTokenizer(medicine , "|");
					medicineReport.nextToken();
					StringTokenizer medicineUniver = new StringTokenizer(medicineReport.nextToken() , ":");
					medicineUniver.nextToken();
					String universalName = medicineUniver.nextToken();
					if (universalName.toLowerCase().contains(name.toLowerCase())) {
						lastUpdate.add(medicine);
						break;
					}
				}
			}
		}catch(Exception exception) {
			System.out.println(exception);
		}
		return lastUpdate;
		
	}
}
