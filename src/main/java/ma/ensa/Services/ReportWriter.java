package ma.ensa.Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportWriter {

    public static void writeSummaryToFile(String title, Map<String, Double> summary, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("=== " + title + " ===\n");
            for (Map.Entry<String, Double> entry : summary.entrySet()) {
                writer.write(String.format("%-20s : $%,.2f%n", entry.getKey(), entry.getValue()));
            }
            System.out.println("✅ Report written to: " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + filename);
            e.printStackTrace();
        }
    }
}
