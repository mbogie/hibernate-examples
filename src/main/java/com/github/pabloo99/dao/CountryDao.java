package com.github.pabloo99.dao;

import com.github.pabloo99.entity.Country;

public class CountryDao extends HibernateDao<Country>{

    public CountryDao() {
        super(Country.class);
    }
}
