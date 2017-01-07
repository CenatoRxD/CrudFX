package sample.interfacesAndClasses;

import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Sviatoslav on 23.12.2016.
 */
public interface IEmployeeFX {

    void add(Employee employee);

    void update(int id, Employee employee);

    void delete(int id);

    Employee get(int id);

    ObservableList<Employee> getAll();
}