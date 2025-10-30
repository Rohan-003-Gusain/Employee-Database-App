# Employee Database App

## Objective
Manage employee records using **Java JDBC** and **MySQL**.  
This console-based application allows you to perform CRUD (Create, Read, Update, Delete) operations on employee data efficiently.

---

## Tools

- **Language:** Java  
- **Database:** MySQL  
- **IDE:** Visual Studio Code 
- **Execution:** Terminal / Command Prompt  

---

## Features

- Add new employee details.  
- View all employee records.  
- Update existing employee information.  
- Delete employee records.  
- Input validation (empty fields, date format, etc.).  
- Proper exception handling using try-catch blocks.  

---

## Database Setup

1. Create a database named **employeedbapp** in MySQL.
2. Run the following SQL command to create the table:
```sql
   CREATE TABLE employees (
       emp_id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(50) NOT NULL,
       email VARCHAR(50) NOT NULL,
       phone VARCHAR(15) NOT NULL,
       dob DATE NOT NULL,
       qualification VARCHAR(50) NOT NULL,
       designation VARCHAR(50) NOT NULL,
       salary DOUBLE NOT NULL
   );
```

---


## How to Run 
1. Compile the Java files:
    ```bash
    javac Main.java Employee.java EmployeeDAO.java DBConnection.java
    ```
2. Run the Program:
    ```bash
    java employeedbapp.Main
    ```
3. Follow the menu to perform operations:
    ```text
        <--- Welcome to Employee Database App --->
        Select an option to perform :
        1. Add Employee
        2. View All Employees
        3. Update Employee Details
        4. Delete Employee
        5. Exit.
        Enter your choice : 1
        Enter Employee Details: ---
        Enter Name: 
        Rohan Gusain
        Enter Email: 
        rohangusain95@gmail.com
        Enter Phone: 
        9548564176
        Enter Date of birth (yyyy-mm-dd): 
        2003-04-17
        Enter Highest Qualification: 
        BCA
        Enter Designation: 
        Java Developer Intern
        Enter Salary: 
        30000
        <--- Employee added successfully --->
            -----------------------------------------
    ```