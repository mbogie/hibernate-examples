package com.github.pabloo99;

import com.github.pabloo99.dao.CountryDao;
import com.github.pabloo99.entity.Country;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountryDaoTest {

    @Test
    public void shouldFindCountryById(){
        CountryDao countryDao = new CountryDao();

        Country country = countryDao.findById("AR");

        Assert.assertTrue(country.getName().equals("Argentina"));
    }
}
