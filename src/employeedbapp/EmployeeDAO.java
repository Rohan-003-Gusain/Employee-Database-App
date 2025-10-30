package employeedbapp;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class EmployeeDAO {

    public void addEmployee (Employee emp) {
        String query = "INSERT INTO employees (name, email, phone, dob, qualification, designation, salary) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getPhone());
            ps.setDate(4, Date.valueOf(emp.getDob()));
            ps.setString(5, emp.getQualification());
            ps.setString(6, emp.getDesignation());
            ps.setDouble(7, emp.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println("Database error: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query)){
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("dob"),
                        rs.getString("qualification"),
                        rs.getString("designation"),
                        rs.getDouble("salary")
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return list; 
    }

    public void updateEmployee(Employee emp) {
        String query = "UPDATE employees SET email = ?, phone = ?, qualification = ?, designation = ?, salary = ? WHERE emp_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            
            ps.setString(1, emp.getEmail());
            ps.setString(2, emp.getPhone());
            ps.setString(3, emp.getQualification());
            ps.setString(4, emp.getDesignation());
            ps.setDouble(5, emp.getSalary());
            ps.setInt(6, emp.getEmp_id());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);
            ps.executeUpdate();  
        } catch (SQLException e) {
             System.out.println("Database error: " + e.getMessage());
        }
    }

    public boolean employeeExists(int id) {
        String query = "SELECT emp_id FROM employees WHERE emp_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Database error while checking employee: " + e.getMessage());
        }
        return false;
    }

}