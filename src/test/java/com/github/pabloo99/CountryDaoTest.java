package com.github.pabloo99;

import com.github.pabloo99.dao.CountryDao;
import com.github.pabloo99.entity.Country;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CountryDaoTest {

    @Test
    public void shouldFindCountryById(){
        CountryDao countryDao = new CountryDao();

        List<Country> countryList = countryDao.findAll();

        Assert.assertTrue(countryList.size() > 0);
    }
}
