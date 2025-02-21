package programming;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class DeletMedicine {
	private PrintWriter trash ;
	private FileWriter file ;
	private RandomAccessFile medicineFile;
	private ArrayList <String> arrayOfMedicine;
	private ArrayList<String> arrayAfterDeletMedicine;
	
	public DeletMedicine(){}
	public boolean deletIt(String medicneName){
		boolean found = false;
		try {
			file = new FileWriter("Bin#.txt" , true);
			trash = new PrintWriter (file);
			medicineFile = new RandomAccessFile ("MedicinesFile#.txt" , "r");
			arrayOfMedicine = new ArrayList<>();//مصفوفه تحوي كل الادويه في الملف ما عدا المحذوف
			arrayAfterDeletMedicine = new ArrayList<>();
			String line;
			while((line = medicineFile.readLine()) != null) { //تفريغ ملف الاديه في المصفوفه
				arrayOfMedicine.add(line);	
				} 
			for (int i = 0 ; i < arrayOfMedicine.size(); i++) {
				System.out.println("before \n " +arrayOfMedicine.get(i));
			}

			int size = arrayOfMedicine.size();
			for(int indexMedicine = 0 ; indexMedicine < size; indexMedicine ++) {//حذف من المصفوفه
				//System.out.println("arrayAfterDeletMedicine.size()"+size);
				if (arrayOfMedicine.get(indexMedicine).toLowerCase().contains(medicneName.toLowerCase())) {
					found = true;
					System.out.println("indexMedicine ==>" + indexMedicine);
					trash.println(arrayOfMedicine.get(indexMedicine));
					trash.flush();
					}
				}
			for (int i = 0 ; i < arrayOfMedicine.size(); i++) {
				System.out.println("after \n " +arrayOfMedicine.get(i));
			}
		}
		catch(Exception exception) {
			System.out.println(exception);
			
			}
		return found;
		}
	}
