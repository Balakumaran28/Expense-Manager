# Expense-Manager

# Overview

Expense Manager is a Java-based command-line application designed to help users record, manage, and analyze daily expenses efficiently. The application supports persistent storage, categorized expense tracking, editing and deletion of records, and basic financial analysis features. It is built using core Java concepts with a clean separation of concerns and robust input validation.

This project demonstrates practical usage of object-oriented programming, file handling, collections, and exception-safe user input handling in Java.


# Features


Add expenses with predefined categories

Automatic date assignment for new expenses

Persistent storage using a local file

View all recorded expenses

Search expenses by category

Sort expenses by amount

View total spending by category

Identify the highest expense

Edit expense details (amount, category, date, description)

Delete expenses safely

User-friendly indexing (1-based indexing for users)

Exception-safe input handling to prevent crashes


# Predefined Expense Categories


The application uses a controlled set of categories to maintain consistency:

Food

Travel

Shopping

Education

Health

Miscellaneous

These categories are enforced during both addition and search operations.


# Project Structure


ExpenseManager/

│

├── Main.java

├── Expense.java

├── ExpenseManager.java

└── expense.txt


# File Description


Main.java
Handles user interaction, menu navigation, and validated input handling.

Expense.java
Represents the expense data model with attributes such as amount, category, date, and description.

ExpenseManager.java
Contains core business logic including CRUD operations, file persistence, sorting, searching, and analytics.

expense.txt
Automatically generated file used to store expense data persistently.


# Technologies Used


Java (Core Java)

Java Collections Framework

File I/O (BufferedReader, BufferedWriter)

Object-Oriented Programming principles


# How Data Persistence Works


All expenses are stored in a local text file (expense.txt).

On application startup, existing expenses are loaded automatically.

Any add, edit, or delete operation updates the file immediately.

Data remains intact across multiple runs of the application.


# How to Run the Project


Ensure Java is installed (JDK 8 or higher).

Clone the repository:

git clone <https://github.com/Balakumaran28/Expense-Manager.git>


Navigate to the project directory.

Compile the Java files:

javac Main.java


Run the application:

java Main

Input Validation and Error Handling

All numeric inputs are validated to prevent invalid data entry.

The application does not crash on incorrect user input.

Clear prompts guide the user to enter valid data.

Index bounds are checked before edit and delete operations.


# Learning Outcomes

 
This project demonstrates:

Real-world application of Java OOP concepts

Safe and validated user input handling

File-based data persistence

Clean command-line user interface design

Modular and maintainable code structure


# Future Enhancements

 
Weekly and monthly expense analysis

Date-based filtering

Export reports to external files

Improved analytics and summaries

Optional GUI interface


# Author

Developed as a hands-on Java learning project focused on clean design, usability, and practical functionality
 
