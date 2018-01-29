package com.github.pabloo99.dao;

import com.github.pabloo99.connection.HibernateUtil;
import com.github.pabloo99.entity.Department;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    private final Logger logger = Logger.getLogger(DepartmentDao.class);

    public List<Department> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        List<Department> departments = new ArrayList<>();

        try {
            transaction = session.beginTransaction();

            departments =
                    session.createQuery("FROM Department").
                            getResultList();

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }

        return departments;
    }

    public Department findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Department department = (Department) session.get(Department.class, id);
            transaction.commit();

            return department;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }

        return null;
    }

    public void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Department department = (Department) session.get(Department.class, id);
            session.delete(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    public void update(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    public void save(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(department);
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
