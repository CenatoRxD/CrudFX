package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Sviatoslav
 * @version 1.0
 */
public class MainControllerTest {
    private ObservableList<Employee> employees;
    private EmployeeDAOImpl dao;

    @Before
    public void setUp() {
        dao = new EmployeeDAOImpl();
        employees = FXCollections.observableArrayList();
    }

    @Test
    public void add() throws Exception {
        dao.add(new Employee("adf", "55", "158239"));
        final ObservableList<Employee> EXPECTED_RESULT = dao.getEmployees();

        assertTrue(!EXPECTED_RESULT.isEmpty());

    }

    @Test
    public void delete() throws Exception {
        dao.add(new Employee("adf", "55", "158239"));
        dao.delete(0);
        final ObservableList<Employee> EXPECTED_RESULT = dao.getEmployees();
        assertTrue(EXPECTED_RESULT.isEmpty());
    }

    @Test
    public void getAll() throws Exception {
        final ObservableList<Employee> EXPECTED_RESULT = dao.getAll();
        final ObservableList<Employee> RESULT = employees;
        assertEquals(EXPECTED_RESULT, RESULT);

    }

}