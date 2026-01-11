import java.util.*;

public class Main {

    static int safeInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static double safeDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Enter a valid amount: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {

            System.out.println("\n1. Add Expense");
            System.out.println("2. Show All");
            System.out.println("3. Search by Category");
            System.out.println("4. Sort by Amount");
            System.out.println("5. Total spending by Category");
            System.out.println("6. Show Highest Expense");
            System.out.println("7. Edit Expense");
            System.out.println("8. Delete Expense");
            System.out.println("9. Exit");
            System.out.print("Enter your option: ");

            int choice = safeInt(sc);
            sc.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Amount: ");
                    double amt = safeDouble(sc);
                    sc.nextLine();

                    System.out.println("Select Category:");
                    System.out.println("1. Food");
                    System.out.println("2. Travel");
                    System.out.println("3. Shopping");
                    System.out.println("4. Education");
                    System.out.println("5. Health");
                    System.out.println("6. Miscellaneous");
                    System.out.print("Enter your option: ");
                    int catChoice = safeInt(sc);
                    sc.nextLine();

                    String cat = switch(catChoice) {
                        case 1 -> "Food";
                        case 2 -> "Travel";
                        case 3 -> "Shopping";
                        case 4 -> "Education";
                        case 5 -> "Health";
                        default -> "Miscellaneous";
                    };

                    String d = java.time.LocalDate.now().toString();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    manager.addExpense(new Expense(amt, cat, d, desc));
                    break;

                case 2:
                    manager.showAllExpenses();
                    break;

                case 3:
                    System.out.println("Select Category:");
                    System.out.println("1. Food");
                    System.out.println("2. Travel");
                    System.out.println("3. Shopping");
                    System.out.println("4. Education");
                    System.out.println("5. Health");
                    System.out.println("6. Miscellaneous");
                    System.out.print("Enter your option: ");
                    int scChoice = safeInt(sc);
                    sc.nextLine();

                    String scCat = switch(scChoice) {
                        case 1 -> "Food";
                        case 2 -> "Travel";
                        case 3 -> "Shopping";
                        case 4 -> "Education";
                        case 5 -> "Health";
                        default -> "Miscellaneous";
                    };

                    manager.searchByCategory(scCat);
                    break;

                case 4:
                    manager.sortByAmount();
                    break;

                case 5:
                    manager.totalByCategory();
                    break;

                case 6:
                    manager.highestExpense();
                    break;

                case 7:
                    manager.showAllExpensesWithIndex();
                    if (manager.isEmpty()) break;

                    System.out.print("Choose expense number to edit: ");
                    int idx = safeInt(sc) - 1;
                    sc.nextLine();

                    if (idx < 0 || idx >= manager.getSize()) {
                        System.out.println("Invalid expense number");
                        break;
                    }

                    System.out.println("1. Update Amount");
                    System.out.println("2. Update Category");
                    System.out.println("3. Update Date");
                    System.out.println("4. Update Description");
                    System.out.print("Enter your option: ");
                    int editChoice = safeInt(sc);
                    sc.nextLine();

                    switch(editChoice) {

                        case 1:
                            System.out.print("New Amount: ");
                            double na = safeDouble(sc);
                            sc.nextLine();
                            manager.updateExpense(idx, na);
                            System.out.println("Updated successfully!");
                            break;

                        case 2:
                            System.out.println("Select New Category:");
                            System.out.println("1. Food");
                            System.out.println("2. Travel");
                            System.out.println("3. Shopping");
                            System.out.println("4. Education");
                            System.out.println("5. Health");
                            System.out.println("6. Miscellaneous");
                            System.out.print("Enter your option: ");
                            int newCat = safeInt(sc);
                            sc.nextLine();

                            String newCategory = switch(newCat) {
                                case 1 -> "Food";
                                case 2 -> "Travel";
                                case 3 -> "Shopping";
                                case 4 -> "Education";
                                case 5 -> "Health";
                                default -> "Miscellaneous";
                            };

                            manager.updateCategory(idx, newCategory);
                            System.out.println("Updated successfully!");
                            break;

                        case 3:
                            System.out.print("New Date (YYYY-MM-DD): ");
                            String nd = sc.nextLine();
                            manager.updateDate(idx, nd);
                            System.out.println("Updated successfully!");
                            break;

                        case 4:
                            System.out.print("New Description: ");
                            String newDesc = sc.nextLine();
                            manager.updateDescription(idx, newDesc);
                            System.out.println("Updated successfully!");
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    break;

                case 8:
                    manager.showAllExpensesWithIndex();
                    if (manager.isEmpty()) break;

                    System.out.print("Enter expense number to delete: ");
                    int num = safeInt(sc);
                    sc.nextLine();
                    manager.deleteExpense(num - 1);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
