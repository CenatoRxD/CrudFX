package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Sviatoslav
 *         That class implements the interface behavior.
 */
public class EmployeeDAOImpl implements IEmployeeDAO {

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    /**
     * @return return our database.
     */
    public ObservableList<Employee> getEmployees() {
        return employeeList;
    }

    /**
     * @param employee - employee whose was added into database.
     */
    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    /**
     * Method changing already added employee.
     *
     * @param id       - id employee in database.
     * @param employee - employee whose will changing.
     */
    @Override
    public void update(int id, Employee employee) {
        employeeList.set(id, employee);
    }

    /**
     * Method will removing employee by ID.
     *
     * @param id - id our employee for deleting.
     */
    @Override
    public void delete(int id) {
        employeeList.remove(id);
    }

    /**
     * Method for searching employee.
     *
     * @param id - id employee whose will searching.
     * @return employee from database.
     */
    @Override
    public Employee get(int id) {
        return employeeList.get(id);
    }

    /**
     * Method for getting all our employees from database.
     *
     * @return
     */
    @Override
    public ObservableList<Employee> getAll() {
        return employeeList;
    }
}
