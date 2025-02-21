package programming;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MedicalStockManagementSystem {
static long medicineNo = 1;
static String medicineUniversalName ;
static String medicineComName ;
static double manufacYear;
static double medicineQuantity;
static double medicinePrice;
static String reorderLimit;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		SpecifiedMedicinePrice specifiedMedicine = new SpecifiedMedicinePrice();
		Medicine2021 mediicne2021 = new Medicine2021();
		FileWriter fileMedicinePrice = new FileWriter("MedicinesAndPrice#.txt" , true);
		PrintWriter nameAndPrice = new PrintWriter(fileMedicinePrice);
		FileWriter fileAllMedicine = new FileWriter("Names#.txt" , true);
		PrintWriter medicineNames = new PrintWriter(fileAllMedicine);
		System.out.println("\t\t\tMedical Stock Management System");
		Medicine medicine = new Medicine(medicineUniversalName , medicineComName , manufacYear , medicineQuantity , medicinePrice , reorderLimit);
		AddNewMedicine newMedicine = new AddNewMedicine(medicineUniversalName , medicineComName , manufacYear , medicineQuantity , medicinePrice , reorderLimit);
		UpdatePrice price = new UpdatePrice();
		UpdateQuatity quantity = new UpdateQuatity ();
		SellMedicine sell = new SellMedicine ();
		Carbage show = new Carbage();
		LastMedicinesUpdate reports = new LastMedicinesUpdate();
		boolean loop = true;
		do {
			System.out.println("1- Add new medicine\n2- Update medicine\n3- Sell medicine\n4- View repotrs\n\ta. All medicine\n\tb. All medicines with less than or equal to a specified price\n\tc. All expired medicine with year less than 2021\n5- Delet medicine\n6- Exite\n Enter operation number:");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 1) {
				System.out.println("Enter quantity you want to add:");
				int newBooksQuantity = scanner.nextInt();
				for(int i = 1 ; i <= newBooksQuantity ; i++) {
					scanner.nextLine();
					System.out.println("Enter medicine universal name:");
					medicineUniversalName = scanner.nextLine();
					System.out.println("Enter medicine commercial name:");
					medicineComName = scanner.nextLine();
					System.out.println("Enter manufacturing year:");
					manufacYear = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter Quantity:");
					medicineQuantity = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter the price:");
					medicinePrice = scanner.nextDouble();
					System.out.println("Enter reorder limit by Days:");
					reorderLimit = scanner.next();
					medicineNo ++;
					nameAndPrice.println(medicineUniversalName +" , "+ medicinePrice);
					nameAndPrice.flush();
					medicineNames.println(medicineUniversalName);
					medicineNames.flush();
					newMedicine.addMedicineInfo(medicineUniversalName , medicineComName , manufacYear , medicineQuantity , medicinePrice , reorderLimit);
				}
				System.out.println("Added Sucsessfuly ! ");
				System.out.println();
			}
			if (choice == 2) {
				System.out.println("Enter Medicine Commercial name ");
				String medicineName = scanner.nextLine();
				System.out.println("What medicine info you want to update \n1- Price\n2- Quantity");
				int numberOfChoice = scanner.nextInt();
				scanner.nextLine();
				if (numberOfChoice == 1) {
					System.out.print("Enter new Price:");
					double newPrice = scanner.nextDouble();
					price.Update(medicineName, newPrice);
					System.out.println("Updated Sucsessfuly !");
				}
					
				else if (numberOfChoice == 2) {
					System.out.println("Enter new Quantity");
					double newQuantity = scanner.nextDouble();
					quantity.Update(medicineName, newQuantity);
					System.out.println("Updated Sucsessfuly !");
				}
					
			}
			if (choice == 3) {
				System.out.println("Entere Medicine Name and quantity:\nMedicine Name:");
				String medicineName = scanner.nextLine();
				System.out.println("Enter Medicine Quantity:");
				int medicineQuantity = scanner.nextInt();
				sell.sellMedicine(medicineName, medicineQuantity);
				
			}
			if (choice == 4) {
				System.out.println("a. All medicine\nb. All medicines with less than or equal to a specified price\nc. All expired medicine with year less than 2021");
				char letter = scanner.next().charAt(0);
				if (letter == 'a' || letter == 'A') {
					ArrayList<String> array  = reports.getMedicineArray();
					for(int  index = array.size() - 1; index >= 0; index--) {
						System.out.println(array.get(index));
						array.remove(index);
					}
					
				}
				else if (letter == 'b' || letter == 'B') {
					System.out.print("Enter Price :");
					double requiredPrice = scanner.nextDouble();
					specifiedMedicine.printMedicinesWithSpecificPrice(requiredPrice);
				}
				else if (letter == 'c' || letter == 'C') {
					mediicne2021.printMedicine2021();
				}
			}
			if (choice == 5) {
				System.out.print("Enter Medicine Name:");
				String delet = scanner.nextLine();
				show.deletIt(delet);
			}
			if (choice == 6) {
				System.out.println("Exit the Program .. ");
				System.exit(0);
			}
			
		}while(loop);
	}

}
