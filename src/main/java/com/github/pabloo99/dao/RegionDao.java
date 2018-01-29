package com.github.pabloo99.dao;

import com.github.pabloo99.entity.Region;
import org.apache.log4j.Logger;

public class RegionDao extends HibernateDao<Region>{

    private final Logger logger = Logger.getLogger(RegionDao.class);

    public RegionDao() {
        super(Region.class);
    }
}
