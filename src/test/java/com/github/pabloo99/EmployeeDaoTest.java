package com.github.pabloo99;

import com.github.pabloo99.dao.EmployeeDao;
import com.github.pabloo99.entity.Employee;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertEquals;


public class EmployeeDaoTest {

    private final Logger logger = Logger.getLogger(EmployeeDaoTest.class);

    private EmployeeDao employeeDao;

    public EmployeeDaoTest() {
        employeeDao = new EmployeeDao();
    }

    @Test
    public void shouldFindAllEmployees() {
        List<Employee> employeeList = employeeDao.findAll();

        Assert.assertTrue(employeeList.size() > 0);
    }

    @Test
    public void shouldFindEmployeeByIs() {
        Employee employee = employeeDao.findById(100);

        Assert.assertTrue(employee.getLastName().equals("King"));
    }

    @Test
    public void shouldFindEmployeeWithDepartmentName() {
        Employee employee = employeeDao.findById(100);

        Assert.assertTrue(employee.getDepartment().getName() != null);
    }

    @Test
    public void shouldSaveAndDeleteEmployee() {
        Employee employeeBeforeSave = employeeDao.findById(100);
        employeeBeforeSave.setId(506);
        employeeBeforeSave.setEmail("test506@gmail.com");

        logger.info("Employee before save: " + employeeBeforeSave.toString());

        employeeDao.save(employeeBeforeSave);

        Employee employeeAfterSave = employeeDao.findById(506);

        employeeDao.delete(506);

        logger.info("Employee after save: " + employeeAfterSave.toString());

        Assert.assertTrue(Objects.equals(employeeBeforeSave.getId(), employeeAfterSave.getId()));
    }

    @Test
    public void shouldUpdateEmployee() {

        Employee employee = employeeDao.findById(200);
        String oldName = employee.getFirstName();

        employee.setFirstName("Sebastian");

        employeeDao.update(employee);

        Employee employeeAfterUpdate = employeeDao.findById(200);
        employee.setFirstName(oldName);

        employeeDao.update(employee);

        assertEquals(employeeAfterUpdate.getFirstName(), "Sebastian");
    }

}
