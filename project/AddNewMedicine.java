package programming;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AddNewMedicine extends Medicine {
private static long medicineNo = 1;
private FileWriter file ;
private PrintWriter writeMedicine;
private Medicine medicine ;

	
	public AddNewMedicine(String medicineUniversalName , String medicineComName , double manufacYear , double medicineQuantity , double medicinePrice , String reorderLimit) {
		super(medicineUniversalName , medicineComName , manufacYear , medicineQuantity , medicinePrice , reorderLimit);
		
		try {
			file = new FileWriter("MedicinesFile#.txt" , true);
			writeMedicine = new PrintWriter(file);
			medicine = new Medicine(medicineUniversalName , medicineComName , manufacYear , medicineQuantity , medicinePrice , reorderLimit);
		}catch(Exception exception) {
			System.out.println(exception);
		}
	}
	public void addMedicineInfo(String medicineUniversalName ,String medicineComName ,double manufacYear ,double medicineQuantity ,double medicinePrice ,String reorderLimit) {
		writeMedicine.println("medicineNo: " + medicineNo + " |medicineUniversalName: "+ medicineUniversalName + " |medicineComName: "+ medicineComName +" |manufacYear: "+ manufacYear + " |medicineQuantity: "+ medicineQuantity + " |medicinePrice: "+ medicinePrice + " |reorderLimit: "+ reorderLimit);
		writeMedicine.flush();
		medicineNo ++;
	}
}
