package com.github.pabloo99;

import com.github.pabloo99.dao.CountryDao;
import com.github.pabloo99.entity.Country;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class CountryDaoTest {

    @Test
    public void shouldFindCountryById(){
        CountryDao countryDao = new CountryDao();

        Country country = countryDao.findById("AR");

        log.info(country.getName());
        log.info(country.getRegion().getName());
        Assert.assertTrue(country.getName().equals("Argentina"));
    }



}
