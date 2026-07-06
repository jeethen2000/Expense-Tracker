import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ExpenseManager {

    private List<Expense> expenses = new ArrayList<>();

    private static final String FILE_NAME = "expenses.csv";

    public ExpenseManager() {
        loadExpenses();
    }

    private int nextId = 1;

    private void loadExpenses() {

        File file = new File(FILE_NAME);
        if (!file.exists())
            return; // no file yet, skip loading

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue; // skip blank lines
                String[] parts = line.split(",");
                if (parts.length < 4)
                    continue; // skip malformed lines

                int id = Integer.parseInt(parts[0]);

                expenses.add(new Expense(
                        id,
                        LocalDate.parse(parts[1]),
                        parts[2],
                        Double.parseDouble(parts[3])));

                if (id >= nextId)
                    nextId = id + 1; // track next available ID
            }
        } catch (IOException e) {
            System.out.println("Error reading expenses file: " + e.getMessage());
        }
    }

    private void saveExpenses() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                pw.println(e.getId() + "," + e.getDate() + "," + e.getDescription() + "," + e.getAmount());
            }

        } catch (IOException e) {
            System.out.println("error saving expenses");
        }
    }

    public void addExpense(String description, double amount) {
        Expense e = new Expense(nextId, LocalDate.now(), description, amount);
        expenses.add(e);
        nextId++;
        saveExpenses();
        System.out.println("Expense added successfully (ID: " + nextId + ")");
    }

    public void deleteExpense(int id) {
        expenses.removeIf(e -> e.getId() == id);
        saveExpenses();
        System.out.println("Expense deleted successfully.");
    }

    public void listExpenses() {
        System.out.println("ID\tDate\tDescription\tAmount");
        for (Expense e : expenses)
            System.out.println(e);
    }

    public void summary(Integer month) {
        double total = 0;
        for (Expense e : expenses) {
            if (month == null || e.getDate().getMonthValue() == month) {
                total += e.getAmount();
            }
        }
        if (month == null)
            System.out.println("Total expenses: $" + total);
        else
            System.out.println("Total expenses for month " + month + ": $" + total);
    }

}