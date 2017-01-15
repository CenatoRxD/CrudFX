package sample.controllers;

import javafx.collections.ObservableList;

/**
 * @author Sviatoslav
 *         Intarface with some behavior
 */
public interface IEmployeeDAO {

    void add(Employee employee);

    void update(int id, Employee employee);

    void delete(int id);

    Employee get(int id);

    ObservableList<Employee> getAll();
}