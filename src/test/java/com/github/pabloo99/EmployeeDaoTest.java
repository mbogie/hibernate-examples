package com.github.pabloo99;

import com.github.pabloo99.dao.EmployeeDao;
import com.github.pabloo99.entity.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EmployeeDaoTest {

    private EmployeeDao employeeDao;

    public EmployeeDaoTest() {
        employeeDao = new EmployeeDao();
    }

    @Test
    public void shouldFindAllEmployees(){
        List<Employee> employeeList = employeeDao.findAll();

        Assert.assertTrue(employeeList.size() > 0);
    }
}
