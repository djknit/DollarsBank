package com.cognixia.jump.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {

	private static File file;
	
	static {
		try {
			file = new File("resources/bankData.javaObjectData");
			if (!file.exists()) file.createNewFile();
		} catch(Exception e) {
			System.out.println("\nERROR: Stored data could not be loaded. YOUR DATA IS NOT BEING SAVED!\n");
//			new AnythingInput(() -> {});
		}
	}
	
	public static void writeToFile(Object objDataToWrite) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			writer.writeObject(objDataToWrite);
		} catch (Exception e) {
			System.out.println("\nERROR: Data file write failed. YOUR DATA COULD NOT BE SAVED!\n");
		}
	}
	
	public static Object getObjectDataFromFile() {
		Object savedData = null;
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			savedData = reader.readObject();
		} catch (Exception e) {
			System.out.println("\nERROR: Stored data failed to load. YOUR DATA MAY NOT BE SAVED!\n");
		}
		return savedData;
	}
	
}
