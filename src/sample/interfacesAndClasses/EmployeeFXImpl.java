package sample.interfacesAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Sviatoslav on 23.12.2016.
 */
public class EmployeeFXImpl implements IEmployeeFX {

    private ObservableList<Employee> employees = FXCollections.observableArrayList();

    public EmployeeFXImpl() {
    }

    public ObservableList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void update(int id, Employee employee) {
        employees.set(id, employee);
    }

    @Override
    public void delete(int id) {
        employees.remove(id);
    }

    @Override
    public Employee get(int id) {
        return employees.get(id);
    }

    @Override
    public ObservableList<Employee> getAll() {
        return employees;
    }
}
