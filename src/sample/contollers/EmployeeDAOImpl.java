package sample.contollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sviatoslav on 23.12.2016.
 */
public class EmployeeDAOImpl implements IEmployeeDAO {

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    public ObservableList<Employee> getEmployees() {
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void update(int id, Employee employee) {
        employeeList.set(id, employee);
    }

    @Override
    public void delete(int id) {
        employeeList.remove(id);
    }

    @Override
    public Employee get(int id) {
        return employeeList.get(id);
    }

    @Override
    public ObservableList<Employee> getAll() {
        return employeeList;
    }
}
