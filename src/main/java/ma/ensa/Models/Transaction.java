package ma.ensa.Models;

import java.time.LocalDate;

public class Transaction {
    public int id;
    public LocalDate localDate;
    public String account;
    public String type;
    public double amount;
    public String category;

    public Transaction(int id , LocalDate date,String account, String type, double amount,String category){
        this.id = id;
        this.localDate = date;
        this.amount = amount;
        this.type = type;
        this.category = category;
    }
    public int getId() { return id; }

    public String getAccount() { return account; }
    public String getType() { return type; }
    public double getAmount() { return amount; }   // <-- IMPORTANT !
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return id + "," + localDate + "," + account + "," + type + "," + amount + "," + category;
    }


}
