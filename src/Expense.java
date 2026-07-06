import java.time.LocalDate;

public class Expense {

    private int id;
    private LocalDate date;
    private String description;
    private double amount;

    public Expense(int id, LocalDate date, String description, double amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%s\t$.2f", id, date, description, amount);
    }

}
