package com.github.pabloo99.dao;

import com.github.pabloo99.connection.HibernateUtil;
import com.github.pabloo99.entity.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private final Logger logger = Logger.getLogger(EmployeeDao.class);

    public List<Employee> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        List<Employee> employees = new ArrayList<>();

        try {
            transaction = session.beginTransaction();

            employees =
                    session.createQuery("FROM Employee").
                            getResultList();

            transaction.commit();

            return employees;
        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);

            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return employees;
    }

    public Employee findById(Integer employeeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // use JPA criteria
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("id", employeeId));

            transaction.commit();

            return (Employee) cr.uniqueResult();
        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);

            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return null;
    }

    public void update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    public void save(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    public void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, id);
            session.delete(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
    }
}
