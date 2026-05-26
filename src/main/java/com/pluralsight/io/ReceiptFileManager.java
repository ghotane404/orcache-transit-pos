package com.pluralsight.io;

import com.pluralsight.model.transaction.Transaction;

import java.io.*;

public class ReceiptFileManager {
	public static void saveReceipt(Transaction transaction){
		try{
			FileWriter fileWriter = new FileWriter("receipt.csv", true);       // saves transaction to the .csv file
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.newLine();       // starting a new line before writing to the files
//			bufferedWriter.write(transaction.formatForCsv());

			bufferedWriter.close();     // closes the writer and saves changes
		}
		catch (Exception e) {
			System.out.println("Error writing to file. Exiting program...");
		}
	}

//	(yyyyMMdd-hhmmss.txt - i.e. 20230329-121523.txt)
//	[yyyy] [MM] [dd] - [hh] [mm] [ss]
//	2023 03 29 - 12 15 23


}
