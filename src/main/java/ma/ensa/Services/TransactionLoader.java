package ma.ensa.Services;

import ma.ensa.Models.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class TransactionLoader {

    public static List<Transaction> load(String filePath){
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                LocalDate date = LocalDate.parse(parts[1]);
                String account = parts[2];
                String type = parts[3];
                double amount = Double.parseDouble(parts[4]);
                String category = parts[5];
                transactions.add(new Transaction(id,date,account,type,amount,category));
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return  transactions;
    }
}
