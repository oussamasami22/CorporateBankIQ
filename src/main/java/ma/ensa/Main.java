package ma.ensa;

import ma.ensa.Models.Transaction;
import ma.ensa.Services.FinancialAnalyzer;
import ma.ensa.Services.TransactionLoader;

import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = TransactionLoader.load("src/main/java/ma/ensa/Sources/corporate_transactions.csv");

        transactions.stream().limit(5).forEach(t -> System.out.println("Account: " + t.getAccount()));

        System.out.println("✅ Loaded Transactions: " + transactions.size());
        transactions.stream().limit(5).forEach(System.out::println);

        System.out.println(" - - - - - - - - - - - - - - - - - - -  \n");
        Map<String, Double> totalByType = FinancialAnalyzer.getTotalAmountByType(transactions);
        FinancialAnalyzer.printSummary("Total by Transaction Type  ", totalByType);

        Map<String,Double> totalByCategory = FinancialAnalyzer.getTotalAmountByCategory(transactions);
        FinancialAnalyzer.printSummary(" Total vy Transaction Category", totalByCategory);
        Map<String,Double> totalByAccount = FinancialAnalyzer.getTotalAmountByAccount(transactions);
        FinancialAnalyzer.printSummary(" Total by Account ",totalByAccount);

    }
}