package programming;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;


public class ReverseFile {
	private RandomAccessFile medicineFile;
	private ArrayList <String> medicineFileArray;
	
	public String returnIntendedLine(String medicineName)throws IOException {
		 String intended = "";
	try {
		String line;
		medicineFile = new RandomAccessFile("MedicinesFile#.txt", "r");
		medicineFileArray = new ArrayList<>();
		while((line = medicineFile.readLine()) != null) {
			medicineFileArray.add(line);
		}
		Collections.reverse(medicineFileArray);
		for (String index : medicineFileArray) {
			if(index.toLowerCase().contains(medicineName.toLowerCase())) {
				intended += index;
				break;
			} 
			
		}
	}catch(Exception exception) {
		System.out.println(exception);
	}
	
		return intended;

	}

}
