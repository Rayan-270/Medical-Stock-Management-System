package programming;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Carbage {
	private FileWriter file;
	private PrintWriter writeInDeleted;
	private RandomAccessFile readFromDeleted;
	private ArrayList<String> deletedMedicine;
	private ReverseFile reverse;
	
	public Carbage() {
		try {
			file = new FileWriter("Bin#.txt" , true);
			writeInDeleted = new PrintWriter(file);
			readFromDeleted = new RandomAccessFile("Bin#.txt" , "r");
			deletedMedicine = new ArrayList<>();
			reverse = new ReverseFile();
		}catch(Exception exception) {
			System.out.println(exception);
		}
	}
	public void deletIt(String medicineName) throws IOException {
		boolean deleted = false;
		String DeletedMedicine;
		while ((DeletedMedicine = readFromDeleted.readLine()) != null) {
			deletedMedicine.add(DeletedMedicine);
		}
		for(String deletedLine : deletedMedicine) {// تتتاك من اذا كان الدواء قد حذف مسبقا ام لا
			if (deletedLine.toLowerCase().equals(medicineName.toLowerCase())) {
				System.out.println("This Medicine Was Deleted Before !");
				deleted = true;
				break;
			}
			}
		if (deleted == false) {
					if (!reverse.returnIntendedLine(medicineName).equals("")) { 
								writeInDeleted.println(medicineName);
								writeInDeleted.flush();
								System.out.println("Medicine Deleted Sucsessfuly !");
					}
					else {
						System.out.println("Medicine Not Found !");
					}
		}
		
	}
}
