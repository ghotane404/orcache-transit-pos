package com.pluralsight.file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

	private static final Path RECEIPT_DIRECTORY = Path.of("receipts");

	public void saveReceipt(String receiptText) {
		try {
			Files.createDirectories(RECEIPT_DIRECTORY);

			Path receiptFile = createReceiptFileName();

			BufferedWriter writer = Files.newBufferedWriter(receiptFile);
			writer.write(receiptText);
			writer.close();

			System.out.println("Receipt saved successfully.");
			System.out.println("Saved location: " + receiptFile.toAbsolutePath());

		} catch (IOException e) {
			System.out.println("Error saving receipt.");
			e.printStackTrace();
		}
	}

	private Path createReceiptFileName() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		String fileName = LocalDateTime.now().format(formatter) + ".txt";

		return RECEIPT_DIRECTORY.resolve(fileName);
	}
}