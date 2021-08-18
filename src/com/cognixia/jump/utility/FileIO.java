package com.cognixia.jump.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {

	private static File file;
	private static File directory = new File("/resources/");
	
	static {
		if (!directory.exists()) {
			directory.mkdir();
		}
		try {
			file = new File("resources" + File.separator + "dlrsBnkProgramData.jObjectStream");
			if (!file.exists()) file.createNewFile();
		} catch(Exception e) {
			System.out.println("\nERROR: Stored data could not be loaded.\n*YOUR DATA IS NOT BEING SAVED!*\n");
		}
	}
	
	public static void writeToFile(Object objDataToWrite) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			writer.writeObject(objDataToWrite);
		} catch (Exception e) {
			System.out.println("\nERROR: Data file write failed.\n* YOUR DATA COULD NOT BE SAVED! *\n");
		}
	}
	
	public static Object getObjectDataFromFile() {
		Object savedData = null;
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			savedData = reader.readObject();
		} catch (Exception e) {
//			System.out.println("\nERROR: Stored data failed to load. YOUR DATA MAY NOT BE SAVED!\n");
		}
		return savedData;
	}
	
}
