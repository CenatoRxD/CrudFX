package sample.contollers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Sviatoslav on 23.12.2016.
 */
public class Employee {
    public static int count = 1;
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty age;
    private SimpleStringProperty salary;

    public Employee(String name, String age, String salary) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
        this.salary = new SimpleStringProperty(salary);
        this.id = new SimpleStringProperty(String.valueOf(count++));
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getSalary() {
        return salary.get();
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

}
