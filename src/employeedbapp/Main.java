package employeedbapp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static EmployeeDAO dao = new EmployeeDAO();
    private static boolean exit = false;

    private static void addEmployee() {
        try {
            System.out.println("Enter Employee Details: ---");

            System.out.println("Enter Name: ");
            String name = sc.nextLine();

            System.out.println("Enter Email: ");
            String email = sc.nextLine();

            System.out.println("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.println("Enter Date of birth (yyyy-mm-dd): ");
            String dob = sc.nextLine();

            try {
                    Date.valueOf(dob); 
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid date format! Please enter in yyyy-mm-dd format.");
                    return;
                }

            System.out.println("Enter Highest Qualification: ");
            String qualification = sc.nextLine();

            System.out.println("Enter Designation: ");
            String designation = sc.nextLine();

            System.out.println("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || dob.isEmpty()
                || qualification.isEmpty() || designation.isEmpty()) {
            System.out.println("All fields are required! Please enter all details.");
            return;
        }

            Employee emp = new Employee(name, email, phone, dob, qualification, designation, salary);
            dao.addEmployee(emp);
            System.out.println("<--- Employee added successfully --->");
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    private static void viewEmployee() {
        System.out.println("<--- List Of Employees --->");
        List<Employee> list = dao.getAllEmployees();
        if (list.isEmpty()) {
            System.out.println("No employess found!");
        } else {
            list.forEach(System.out::println);
        }
    }

    private static void updateEmployee() {
        try {
            System.out.println("Enter Employee ID to update: ");
            int emp_id = sc.nextInt();
            sc.nextLine();

            if (!dao.employeeExists(emp_id)) {
                System.out.println("Employee ID not found!");
                return;
            }

            System.out.println("Enter Email: ");
            String email = sc.nextLine();

            System.out.println("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.println("Enter Qualification: ");
            String qualification = sc.nextLine();

            System.out.println("Enter Designation: ");
            String designation = sc.nextLine();

            System.out.println("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee emp = new Employee();
            emp.setEmp_id(emp_id);
            emp.setEmail(email);
            emp.setPhone(phone);
            emp.setQualification(qualification);
            emp.setDesignation(designation);
            emp.setSalary(salary);

            dao.updateEmployee(emp);
            System.out.println("<--- Employee updated successfully ---.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployee() {
        try {
            if (dao.getAllEmployees().isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
            System.out.println("Enter employee Id to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (!dao.employeeExists(id)) {
                System.out.println("Employee ID not found!");
                return;
            }

            dao.deleteEmployee(id);
            System.out.println("<--- Employee deleted successfully --->");
            
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("<--- Welcome to Employee Database App --->");

        while (!exit) {
            System.out.println("Select an option to perform :");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Details");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit.");
            System.out.print("Enter your choice : ");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        addEmployee();
                    }
                    case 2 -> {
                        viewEmployee();
                    }
                    case 3 -> {
                        updateEmployee();
                    }
                    case 4 -> {
                        deleteEmployee();
                    }
                    case 5 -> {
                        exit = true;
                        System.out.println("<--- Exiting from Employee Database App --->");
                    }
                
                    default -> {
                        System.out.println("Invalid choice, Please select a valid choice!");
                    }
                }
                System.out.println("-----------------------------------------");
            } else {
                System.out.println("Invalid choice, Please select a valid choice!");
                sc.nextLine();
                continue;
            }
        }
        sc.close();
    }
    
}
