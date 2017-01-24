package sample.controllers;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Sviatoslav
 * @version 1.0
 *          This class for creating new employees.
 */
public class Employee {
    private SimpleStringProperty name;
    private SimpleStringProperty age;
    private SimpleStringProperty salary;

    /**
     * Constructor for creating new employee;
     *
     * @param name   - name of new employee;
     * @param age    - age of employee;
     * @param salary - age of employee.
     */
    public Employee(String name, String age, String salary) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
        this.salary = new SimpleStringProperty(salary);
    }

    /**
     * @return Name our employee.
     */
    public String getName() {
        return name.get();
    }

    /**
     * @param name - can set new name of employee or update here old name.
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * @return Age of employee.
     */
    public String getAge() {
        return age.get();
    }

    /**
     * @param age can set new age of employee or update here old age.
     */
    public void setAge(String age) {
        this.age.set(age);
    }

    /**
     * @return Salary of employee.
     */
    public String getSalary() {
        return salary.get();
    }

    /**
     * @param salary can set new salary of employee or update here old salary.
     */
    public void setSalary(String salary) {
        this.salary.set(salary);
    }

}
