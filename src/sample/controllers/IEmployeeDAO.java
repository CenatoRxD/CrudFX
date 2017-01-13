package sample.controllers;

import javafx.collections.ObservableList;

/**
 * Created by Sviatoslav on 23.12.2016.
 */
public interface IEmployeeDAO {

    void add(Employee employee);

    void update(int id, Employee employee);

    void delete(int id);

    //Employee get(int id);

    ObservableList<Employee> getAll();
}