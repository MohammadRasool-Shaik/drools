package org.rash.drools.model.employee;

public class Employee {
    String name;
    boolean isManager;
    String message;
    double salary;
    Department department;

    public Employee(String name, boolean isManager, double salary) {
        this.name = name;
        this.isManager = isManager;
        this.salary = salary;
    }

    public Employee(String name, boolean isManager, double salary, Department department) {
        this.name = name;
        this.isManager = isManager;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", isManager=" + isManager +
                ", message='" + message + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
