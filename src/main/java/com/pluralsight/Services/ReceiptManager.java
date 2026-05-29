package com.pluralsight.Services;
//import my models order

import com.pluralsight.Models.Order;

//add a file writer and the date/time now
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    //create receipt
    public void createReceipt(Order order) {
        File folder = new File("receipts");

        //if no folder exists make one
        if (!folder.exists()) {
            folder.mkdir();
        }

        //create a file writer
        try {
            //create a file name with the date and time in given format
            DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String fileName = LocalDateTime.now().format(myFormatter) + ".txt";

            File receiptFile = new File(folder, fileName);

            //write try catch for receipt file
            try (FileWriter myWriter = new FileWriter(receiptFile)) {
                myWriter.write(order.getOrderDetailsAndFormat());
                System.out.println("Receipt Successfully Created: " + receiptFile.getPath());
            } catch (IOException e) {
                System.out.println("An Error Occurred While Creating Receipt." + e.getLocalizedMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
