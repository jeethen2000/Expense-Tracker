📘 Expense Tracker CLI (Java)
A simple command‑line expense tracker built in Java, designed to help users record, list, and summarize daily expenses efficiently using a CSV file for storage.

🚀 Features
Add expenses with description and amount

List all expenses with ID, date, description, and amount

Delete expenses by ID

Monthly summary of total spending

Persistent storage using CSV file

🧱 Project Structure
```
ExpenseTracker/
├── src/
│   ├── Expense.java
│   ├── ExpenseManager.java
│   └── ExpenseTracker.java
└── expenses.csv
```

⚙️ How to Run
Compile the project:
```
bash
javac ExpenseTracker.java
```

Run commands:
```
bash
java ExpenseTracker add --description "Lunch" --amount 250
java ExpenseTracker list
java ExpenseTracker summary --month 7
java ExpenseTracker delete --id 2
```
🧠 Example Output
```
ID   Date         Description   Amount
1    2026-07-06   Lunch         $250.00
2    2026-07-06   Dinner        $180.00
Total expenses: $430.00
```

🧩 Future Enhancements
Expense categories

Budget alerts

JSON storage

Export to Excel

🧰 Technologies Used
| ⚙️ Component          | 🧩 Description            |
|-----------------------|---------------------------|
| **Java 17+**          | Core language             |
| **CSV File I/O**      | Persistent data storage   |
| **LocalDate API**     | Date handling             |
| **Command-line args** | User input management     |


🧑‍💻 Author
Jeethen Crasta  
Passionate Java developer building practical CLI tools and full‑stack applications.
