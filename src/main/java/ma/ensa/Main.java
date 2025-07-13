package ma.ensa;

import ma.ensa.Models.Transaction;
import ma.ensa.Services.TransactionLoader;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = TransactionLoader.load("src/main/java/ma/ensa/Sources/corporate_transactions.csv");
        System.out.println("✅ Loaded Transactions: " + transactions.size());
        transactions.stream().limit(5).forEach(System.out::println);
    }
}