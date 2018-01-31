package com.github.pabloo99;

import com.github.pabloo99.dao.CountryDao;
import com.github.pabloo99.dao.DepartmentDao;
import com.github.pabloo99.entity.Region;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
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

    @Test
    public void findInformationAboutRegionContinent() {
        CountryDao countryDao = new CountryDao();

        Region region = countryDao.findById("AR").getRegion();

        Assert.assertTrue(region.getName().equals("Americas"));
    }
}
