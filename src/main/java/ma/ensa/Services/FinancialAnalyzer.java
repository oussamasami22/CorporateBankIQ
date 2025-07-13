package ma.ensa.Services;

import ma.ensa.Models.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinancialAnalyzer {
   public  static Map<String,Double> getTotalAmountByType(List<Transaction> transactions){
       return transactions.stream()
               .collect(Collectors.groupingBy(t -> t.type.toUpperCase(),Collectors.summingDouble(t -> t.amount)));

   }
   public static Map<String, Double> getTotalAmountByCategory(List<Transaction> transactions){
      return  transactions.stream()
              .collect(Collectors.groupingBy(t -> t.category,Collectors.summingDouble(t->t.amount)));

   }

   public  static Map<String, Double> getTotalAmountByAccount(List<Transaction> transactions){
      return transactions.stream()
              .collect(Collectors.groupingBy(t-> t.account, Collectors.summingDouble(t -> t.amount)));

   }
   public static void printSummary(String title, Map<String, Double> map) {
      System.out.println("\n=== " + title + " ===");
      map.forEach((k, v) -> System.out.printf("%-20s : $%,.2f\n", k, v));
   }
}
