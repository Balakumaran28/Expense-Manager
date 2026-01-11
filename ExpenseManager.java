import java.util.*;
import java.io.*;

class ExpenseManager{
    List<Expense> expenses=new ArrayList<Expense>();
    final String fileName="expense.txt";
    public ExpenseManager(){
        loadFromFile();
    }
    public void addExpense(Expense e){
        expenses.add(e);
        saveToFile();
    }
    public void showAllExpenses(){
        if(expenses.isEmpty()) {
            System.out.println("No expenses add yet..");
            return;
        }
        for(Expense e:expenses){
            System.out.println(e);
        }
    }
    public void saveToFile(){
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
            for(Expense e:expenses){
            writer.write(e.getAmount()+","+e.getCategory()+","+e.getDate()+","+e.getDescription());
            writer.newLine();
            }
            writer.close();
    }
        catch (IOException e){
            System.out.println("Error saving to file"+e);
        }
    }
    public void loadFromFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                double amt = Double.parseDouble(data[0]);
                Expense e = new Expense(amt, data[1], data[2], data[3]);
                expenses.add(e);
            }
            reader.close();
        }
        catch(IOException e){

        }
    }
    public void searchByCategory(String category) {
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found for category: " + category);
        }
    }
    public void sortByAmount() {
        expenses.sort(Comparator.comparingDouble(Expense::getAmount));
        showAllExpenses();
    }
    public void totalByCategory() {
        Map<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(e.getCategory(),
                    map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        for (String c : map.keySet()) {
            System.out.println(c + " : Rs." + map.get(c));
        }
    }
    public void highestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses.");
            return;
        }

        Expense max = Collections.max(expenses,
                Comparator.comparingDouble(Expense::getAmount));

        System.out.println("Highest Expense:");
        System.out.println(max);
    }
    public void updateExpense(int index, double newAmount) {
        if (index < 0 || index >= expenses.size()) {
            System.out.println("Invalid index");
            return;
        }

        Expense e = expenses.get(index);
        e.setAmount(newAmount);
        saveToFile();

    }
    public void showAllExpensesWithIndex() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded!");
            return;
        }

        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + " -> " + expenses.get(i));
        }
    }

    public void deleteExpense(int index) {
        if (index < 0 || index >= expenses.size()) {
            System.out.println("Invalid index");
            return;
        }

        expenses.remove(index);
        saveToFile();
        System.out.println("Expense deleted!");
    }
    public void updateCategory(int index, String c) {
        expenses.get(index).setCategory(c);
        saveToFile();
    }

    public void updateDate(int index, String d) {
        expenses.get(index).setDate(d);
        saveToFile();
    }

    public void updateDescription(int index, String desc) {
        expenses.get(index).setDescription(desc);
        saveToFile();
    }
    public int getSize() {
        return expenses.size();
    }
    public boolean isEmpty() {
        return expenses.isEmpty();
    }



}