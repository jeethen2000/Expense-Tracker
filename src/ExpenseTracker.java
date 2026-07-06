public class ExpenseTracker {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        if (args.length == 0) {
            System.out.println("Usage: add | delete | list | summary");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                String description = null;
                Double amount = null;

                for (int i = 1; i < args.length; i++) {
                    if (args[i].equals("--description") && i + 1 < args.length) {
                        description = args[++i];
                    } else if (args[i].equals("--amount") && i + 1 < args.length) {
                        amount = Double.parseDouble(args[++i]);
                    }
                }

                if (description == null || amount == null) {
                    System.out.println("Usage: add --description <text> --amount <number>");
                    return;
                }

                manager.addExpense(description, amount);
                break;

            case "delete":
                Integer id = null;
                for (int i = 1; i < args.length; i++) {
                    if (args[i].equals("--id") && i + 1 < args.length) {
                        id = Integer.parseInt(args[++i]);
                    }
                }
                if (id == null) {
                    System.out.println("Usage: delete --id <number>");
                    return;
                }
                manager.deleteExpense(id);
                break;

            case "list":
                manager.listExpenses();
                break;

            case "summary":
                Integer month = null;
                for (int i = 1; i < args.length; i++) {
                    if (args[i].equals("--month") && i + 1 < args.length) {
                        month = Integer.parseInt(args[++i]);
                    }
                }
                manager.summary(month);
                break;

            default:
                System.out.println("Invalid command.");
        }
    }
}
