package programming;
import java.io.IOException;
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
		PharmacyDatabase pharmacy = new PharmacyDatabase();
		System.out.println("\t\t\tMedical Stock Management System");
		UpdatePrice price = new UpdatePrice();
		UpdateQuatity quantity = new UpdateQuatity ();
		SellMedicine sell = new SellMedicine ();
		Carbage carbage = new Carbage();
		MedicinesReports reports = new MedicinesReports();
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
					System.out.println("\tMedicine number:" + medicineNo);
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
					Medicine medicine = new Medicine(medicineUniversalName , medicineComName , manufacYear , medicineQuantity , medicinePrice , reorderLimit);
					pharmacy.saveMedicine(medicineUniversalName, medicineComName, manufacYear, medicineQuantity, medicinePrice, reorderLimit);
					pharmacy.saveName(medicineComName); 
					pharmacy.saveNameAndPrice(medicineComName, medicinePrice);
					if(manufacYear <= 2021) {
						pharmacy.save2021(medicineUniversalName, medicineComName, manufacYear, medicineQuantity, medicinePrice, reorderLimit);
					}
				}
				System.out.println("Added Successfuly ! ");
				System.out.println();
			}
			if (choice == 2) {
				System.out.println("Enter Medicine Commercial name ");
				String medicineName = scanner.nextLine();
				System.out.println("Which medicine's info you want to update? \n1- Price\n2- Quantity");
				int numberOfChoice = scanner.nextInt();
				scanner.nextLine();
				if (numberOfChoice == 1) {
					System.out.print("Enter new Price:");
					double newPrice = scanner.nextDouble();
					price.Update(medicineName, newPrice);
					System.out.println("Updated Successfuly !");
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
					for(String medicine : array) {
						System.out.println(medicine);
					}
					
				}
				else if (letter == 'b' || letter == 'B') {
					System.out.print("Enter Price :");
					double requiredPrice = scanner.nextDouble();
					ArrayList<String> array = reports.getSpecificMedicines(requiredPrice);
					for(String medicine : array) {
						System.out.println(medicine);
					 }
					}
				else if (letter == 'c' || letter == 'C') {
					ArrayList<String> array = reports.getMedicine2021();
					for(String medicine : array) {
						System.out.println(medicine);
					 }
				}
			}
			if (choice == 5) {
				System.out.print("Enter Medicine Universal Name:");
				String delet = scanner.nextLine();
				carbage.deletIt(delet);
			}
			if (choice == 6) {
				System.out.println("Exit the Program .. ");
				System.exit(0);
			}
			
		}while(loop);
	}

}
