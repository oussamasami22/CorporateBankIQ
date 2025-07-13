package ma.ensa.Services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import ma.ensa.Models.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class TransactionLoader {

    public static List<Transaction> load(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        System.out.println("📄 Reading file from: " + filePath);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // 👈 skip header row

            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length < 6) continue;

                int id = Integer.parseInt(line[0].trim());
                LocalDate date = LocalDate.parse(line[1].trim());
                String account = line[2].trim();
                if (account.equalsIgnoreCase("null") || account.isBlank()) {
                    account = "UNKNOWN";
                }

                String type = line[3].trim();
                double amount = Double.parseDouble(line[4].trim());
                String category = line[5].trim();

                transactions.add(new Transaction(id, date, account, type, amount, category));
            }
        }


        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
        return  transactions;
    }
}
