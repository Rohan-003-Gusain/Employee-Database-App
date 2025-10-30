package employeedbapp;

public class Employee {
    private int emp_id;
    private String name;
    private String email;
    private String phone;
    private String dob;
    private String qualification;
    private String designation;
    private double salary;

    public Employee() {
    }

    public Employee(int emp_id, String name, String email, String phone, String dob, String qualification,
        String designation, double salary) {
        this.emp_id = emp_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.qualification = qualification;
        this.designation = designation;
        this.salary = salary;
    }

    public Employee(String name, String email, String phone, String dob, String qualification,
        String designation, double salary) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.qualification = qualification;
        this.designation = designation;
        this.salary = salary;
    }


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee {emp_id=" + emp_id + 
                ", name=" + name + 
                ", email=" + email + 
                ", phone=" + phone + 
                ", dob=" + dob + 
                ", qualification=" + qualification + 
                ", designation=" + designation + 
                ", salary=" + salary + 
                "}";
    }

}
