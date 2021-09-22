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
			file = new File(
					"resources" + File.separator + "dlrsBnkProgramData.jObjectStream");
			if (!file.exists()) file.createNewFile();
		} catch(Exception e) {
			announceProblem();
		}
	}
	
	public static void writeToFile(Object objDataToWrite) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			writer.writeObject(objDataToWrite);
		} catch (Exception e) {
			announceProblem("Data write to file failed.");
		}
	}
	
	public static Object getObjectDataFromFile() {
		Object savedData = null;
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			savedData = reader.readObject();
		} catch (Exception e) {
			announceProblem();
		}
		return savedData;
	}

	private static void announceProblem() {
		announceProblem("Stored data could not be loaded.");
	}
	private static void announceProblem(String message) {
		System.out.println(Colors.RED.colorize(
				"\nERROR: " + message + "\n* YOUR DATA IS NOT BEING SAVED PROPERLY! *\n"));
	}
	
}
