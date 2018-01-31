package com.github.pabloo99.dao;

import com.github.pabloo99.connection.HibernateUtil;
import com.github.pabloo99.entity.Country;
import com.github.pabloo99.entity.Employee;
import lombok.extern.log4j.Log4j;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@Log4j
public class CountryDao extends HibernateDao<Country>{

    public CountryDao() {
        super(Country.class);
    }

    public Country findById(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // use JPA criteria
            Criteria cr = session.createCriteria(Country.class);
            cr.add(Restrictions.eq("id", id));

            //transaction.commit();

            return (Country) cr.uniqueResult();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);

            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return null;
    }
}
