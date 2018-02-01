package com.github.pabloo99;

import com.github.pabloo99.dao.DepartmentDao;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j
public class DepartmentDaoTest {

    @Test
    public void shouldReturnEmployeeCount() {
        DepartmentDao departmentDao = new DepartmentDao();

        int count = departmentDao.countEmployeesByDepartmentId(60);

        assertEquals(count, 5);
    }
}
